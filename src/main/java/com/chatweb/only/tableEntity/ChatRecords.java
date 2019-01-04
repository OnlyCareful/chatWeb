package com.chatweb.only.tableEntity;

import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author z
 * @since 2019-01-04
 */
public class ChatRecords extends Model<ChatRecords> {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.UUID)
    private String id;
    /**
     * 发送者ID
     */
    private String send;
    /**
     * 发送者ID
     */
    private String receive;
    /**
     * 内容
     */
    private String content;
    /**
     * 创建时间
     */
    private Date creationDate = new Date();


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSend() {
        return send;
    }

    public void setSend(String send) {
        this.send = send;
    }

    public String getReceive() {
        return receive;
    }

    public void setReceive(String receive) {
        this.receive = receive;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "ChatRecords{" +
        ", id=" + id +
        ", send=" + send +
        ", receive=" + receive +
        ", content=" + content +
        ", creationDate=" + creationDate +
        "}";
    }
}
