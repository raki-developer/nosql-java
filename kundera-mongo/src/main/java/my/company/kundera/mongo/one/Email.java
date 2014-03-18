package my.company.kundera.mongo.one;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Email")
public class Email {
    @Id
    @Column(name = "messageId")
    private String messageId;
    
    private String subject;
    
    private String body;
    
    @Embedded
    private Contact fromCnt;
    
    @ElementCollection
    @CollectionTable(name = "toContact")
    private List<Contact> to = new ArrayList<Contact>();
    
    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name="messageId")
    private List<Attachment> attachments = new ArrayList<Attachment>();

    /**
     * @return the messageId
     */
    public String getMessageId() {
        return messageId;
    }

    /**
     * @param messageId the messageId to set
     */
    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    /**
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * @return the body
     */
    public String getBody() {
        return body;
    }

    /**
     * @param body the body to set
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * @return the fromCnt
     */
    public Contact getFromCnt() {
        return fromCnt;
    }

    /**
     * @param fromCnt the fromCnt to set
     */
    public void setFromCnt(Contact fromCnt) {
        this.fromCnt = fromCnt;
    }

    /**
     * @return the to
     */
    public List<Contact> getTo() {
        return to;
    }

    /**
     * @param to the to to set
     */
    public void setTo(List<Contact> to) {
        this.to = to;
    }

    /**
     * @return the attachments
     */
    public List<Attachment> getAttachments() {
        return attachments;
    }

    /**
     * @param attachments the attachments to set
     */
    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }

    void addTo(Contact contact) {
        to.add(contact);
    }

    void addAttachment(Attachment attachment) {
        attachments.add(attachment);
    }
    
    
}
