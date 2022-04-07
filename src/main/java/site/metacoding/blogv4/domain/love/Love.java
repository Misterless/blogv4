package site.metacoding.blogv4.domain.love;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import site.metacoding.blogv4.domain.post.Post;
import site.metacoding.blogv4.domain.user.User;

@EntityListeners(AuditingEntityListener.class) // 이 부분 추가
@Entity
@Table(uniqueConstraints = {
    @UniqueConstraint(name = "love_uk", columnNames = { "postId", "userId" })
})
public class Love {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JoinColumn(name = "postId")
    @ManyToOne
    private Post post;
    @JoinColumn(name = "userId")
    @ManyToOne
    private User user;
    @CreatedDate // insert 할때만 동작
    private LocalDateTime createDate;
    @LastModifiedDate // update 할때만 동작
    private LocalDateTime updateDate;
}

