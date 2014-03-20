package raki.shop.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "orders")
public class Order implements Serializable {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    protected String id;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date date;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="order_id", nullable = false)
    protected Set<Item> items = new HashSet<Item>();

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the items
     */
    public Set<Item> getItems() {
        return items;
    }

    /**
     * @param items the items to set
     */
    public void setItems(Set<Item> items) {
        this.items = items;
    }
    
    
}
