package com.encocns.enfra.batch.core.item.file;

public class EnfraFileWriterConfig {

    private String outputResourceFullPath;
    private String delimiter;
    private Class<?> beanNames;
    private boolean isHeaderCopy = false;
    private boolean isAppendAllowed = false;

    /**
     * @return the outputResourceFullPath
     */
    public String getOutputResourceFullPath() {
        return outputResourceFullPath;
    }
    /**
     * @param outputResourceFullPath the outputResourceFullPath to set
     */
    public void setOutputResourceFullPath(String outputResourceFullPath) {
        this.outputResourceFullPath = outputResourceFullPath;
    }
    /**
     * @return the delimiter
     */
    public String getDelimiter() {
        return delimiter;
    }
    /**
     * @param delimiter the delimiter to set
     */
    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }
    /**
     * @return the beanNames
     */
    public Class<?> getBeanNames() {
        return beanNames;
    }
    /**
     * @param beanNames the beanNames to set
     */
    public void setBeanNames(Class<?> beanNames) {
        this.beanNames = beanNames;
    }
    /**
     * @return the isHeaderCopy
     */
    public boolean isHeaderCopy() {
        return isHeaderCopy;
    }
    /**
     * @param isHeaderCopy the isHeaderCopy to set
     */
    public void setHeaderCopy(boolean isHeaderCopy) {
        this.isHeaderCopy = isHeaderCopy;
    }
    /**
     * @return the isAppendAllowed
     */
    public boolean isAppendAllowed() {
        return isAppendAllowed;
    }
    /**
     * @param isAppendAllowed the isAppendAllowed to set
     */
    public void setAppendAllowed(boolean isAppendAllowed) {
        this.isAppendAllowed = isAppendAllowed;
    }
    
}
