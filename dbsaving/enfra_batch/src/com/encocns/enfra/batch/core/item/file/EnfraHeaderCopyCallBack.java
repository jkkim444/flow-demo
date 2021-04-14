package com.encocns.enfra.batch.core.item.file;

import java.io.IOException;
import java.io.Writer;

import org.springframework.batch.item.file.FlatFileHeaderCallback;
import org.springframework.batch.item.file.LineCallbackHandler;
import org.springframework.util.Assert;

public class EnfraHeaderCopyCallBack implements LineCallbackHandler, FlatFileHeaderCallback{

    private String header = "";
    
    public EnfraHeaderCopyCallBack(String columns) {
        this.header = columns;
    }
    
    @Override
    public void writeHeader(Writer writer) throws IOException {
        writer.write(header);
    }

    @Override
    public void handleLine(String line) {
        Assert.notNull(line, "[Assertion failed] - this argument is required; it must not be null");
        
        this.header = line;
    }

}
