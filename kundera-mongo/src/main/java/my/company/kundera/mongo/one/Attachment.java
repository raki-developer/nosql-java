package my.company.kundera.mongo.one;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ATTACHMENT")
public class Attachment {

    @Id
    @Column(name = "ATTCHMENT_ID")
    private String attachmentId;

    @Column(name = "FILE_NAME")
    private String fileName;

    @Column(name = "FILE_TYPE")
    private String fileType;
    //Getters, setters, constructors and utility methods omitted.

    public Attachment() {
    }

    Attachment(String attachmentId, String fileName, String fileType) {
        this.attachmentId = attachmentId;
        this.fileName = fileName;
        this.fileType = fileType;
    }

    /**
     * @return the attachmentId
     */
    public String getAttachmentId() {
        return attachmentId;
    }

    /**
     * @param attachmentId the attachmentId to set
     */
    public void setAttachmentId(String attachmentId) {
        this.attachmentId = attachmentId;
    }

    /**
     * @return the fileName
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * @param fileName the fileName to set
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * @return the fileType
     */
    public String getFileType() {
        return fileType;
    }

    /**
     * @param fileType the fileType to set
     */
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    
}
