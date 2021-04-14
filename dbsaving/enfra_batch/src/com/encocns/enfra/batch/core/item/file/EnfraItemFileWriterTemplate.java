package com.encocns.enfra.batch.core.item.file;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.core.io.FileSystemResource;
import org.springframework.util.Assert;

import com.encocns.enfra.batch.core.annotation.Header;

public class EnfraItemFileWriterTemplate {

    private final FlatFileItemWriter<Object> flatFileItemWriter;
    
    public EnfraItemFileWriterTemplate(EnfraFileWriterConfig config) {
        flatFileItemWriter = new FlatFileItemWriter<Object>();
        
        if(config.getOutputResourceFullPath() == null) {
            Assert.notNull(config.getOutputResourceFullPath(), "[Assertion failed] - this argument is required; it must not be null");
        }
        
        //ClassPathResource resource = new ClassPathResource("dummy.txt");
        FileSystemResource resource = new FileSystemResource(config.getOutputResourceFullPath());
        
        flatFileItemWriter.setResource(resource);
        
        flatFileItemWriter.setAppendAllowed(true);
        
        DelimitedLineAggregator<Object> dla = new DelimitedLineAggregator<Object>();
        
        if(config.getDelimiter() == null) {
            dla.setDelimiter(";");
        } else {
            dla.setDelimiter(config.getDelimiter());
        }
        
        BeanWrapperFieldExtractor<Object> bwfe = new BeanWrapperFieldExtractor<Object>();
        
        List<String> listHeader = new ArrayList<String>();
        
        List<String> list = new ArrayList<String>();
        
        if(config.getBeanNames() == null) {
            Assert.notNull(config.getBeanNames(), "[Assertion failed] - this argument is required; it must not be null");
        }
        
        for(Field field : config.getBeanNames().getDeclaredFields()) {
            list.add(field.getName());
            
            if(field.getAnnotation(Header.class) != null) {
                listHeader.add(field.getAnnotation(Header.class).value());
            } else {
                Assert.notNull(config.getBeanNames(), "[Assertion failed] - this argument annotation is required; it must not be null");
            }
        }
        
//        bwfe.setNames(new String[] {"dummy1", "dummy2"});
        String[] beanWrapperFields = list.toArray(new String[0]);
        bwfe.setNames(beanWrapperFields);
                
        dla.setFieldExtractor(bwfe);
        
        flatFileItemWriter.setLineAggregator(dla);
        
        // Header 출력이 필요하다면
        if(config.isHeaderCopy()) {
            if(listHeader.size() > 0) {
                StringBuilder sb = new StringBuilder();
                
                for(String beanRow : listHeader) {
                    if(sb.length() > 0) {
                        sb.append(config.getDelimiter());
                    }
                    
                    sb.append(beanRow);
                }
                
                EnfraHeaderCopyCallBack hcc = new EnfraHeaderCopyCallBack(sb.toString());
                
                flatFileItemWriter.setHeaderCallback(hcc);
            }
        }
        
        if(config.isAppendAllowed()) {
            flatFileItemWriter.setAppendAllowed(true);
        } else {
            flatFileItemWriter.setAppendAllowed(false);
        }
        
    }
    
    public void writeAll(EnfraFlatFileRecordWriter<? extends Object> fwc) throws Exception {
        try {
            List<? extends Object> returnValue = fwc.doWrite();
            flatFileItemWriter.open(new ExecutionContext());
            flatFileItemWriter.write(returnValue);
        } finally {
            flatFileItemWriter.close();
        }
    }
    
}
