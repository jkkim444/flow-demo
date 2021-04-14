package com.encocns.enfra.batch.core.item.file;

import java.util.List;

public interface EnfraFlatFileRecordWriter<T> {

    List<? extends T> doWrite();
    
}