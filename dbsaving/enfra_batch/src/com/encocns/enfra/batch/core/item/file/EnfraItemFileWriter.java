package com.encocns.enfra.batch.core.item.file;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.BeanUtils;

public class EnfraItemFileWriter {

    private EnfraItemFileWriterTemplate itemFileWriterTemplate;
    
    public EnfraItemFileWriter(EnfraFileWriterConfig config) throws RuntimeException {
        itemFileWriterTemplate = new EnfraItemFileWriterTemplate(config);
    }
    
    public void write(Object param) throws Exception {
        Object paramNewClass = param.getClass().newInstance();
        
        BeanUtils.copyProperties(param, paramNewClass);
        
        itemFileWriterTemplate.writeAll(new EnfraFlatFileRecordWriter<Object>(){
            @Override
            public List<? extends Object> doWrite() {
                return Arrays.asList(paramNewClass);
            }
        });
    }
    
    public void writeAll(List<? extends Object> listParam) throws Exception {
        itemFileWriterTemplate.writeAll(new EnfraFlatFileRecordWriter<Object>(){
            @Override
            public List<? extends Object> doWrite() {
                return listParam;
            }
        });
    }
    
}
