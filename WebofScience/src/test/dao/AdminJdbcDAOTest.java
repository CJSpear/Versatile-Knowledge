
import dao.AdminJdbcDAO;
import dao.ArticleJdbcDAO;
import dao.UserJdbcDAO;
import dao.VerifierJdbcDAO;
import domain.Admin;
import domain.Article;
import domain.User;
import domain.Verifier;
import java.time.Instant;
import java.util.Date;
import static java.util.function.Predicate.not;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

/*
  * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
*/
  
  /**
  *
  * @author sarahaverill
*/
  public class AdminJdbcDAOTest {
    
    ArticleJdbcDAO r = new ArticleJdbcDAO("jdbc:h2:mem:tests;INIT=runscript from 'src/main/java/dao/databaseSchema.sql'");
    UserJdbcDAO u = new UserJdbcDAO("jdbc:h2:mem:tests;INIT=runscript from 'src/main/java/dao/databaseSchema.sql'");
    AdminJdbcDAO d = new AdminJdbcDAO("jdbc:h2:mem:tests;INIT=runscript from 'src/main/java/dao/databaseSchema.sql'");
    VerifierJdbcDAO v = new VerifierJdbcDAO("jdbc:h2:mem:tests;INIT=runscript from 'src/main/java/dao/databaseSchema.sql'");
    
    private Article r1;
    private Article  r2;
    private Article r4;
    
    private User u1;
    private User u2;
    private User u4;
    
    private Admin d1;
    private Admin d2;
    private Admin d4;
    
    private Verifier v1;
    private Verifier v2;
    private Verifier v4;
    
    public AdminJdbcDAOTest() {
    }
    
    @BeforeEach
    public void setUp() {
      
      r1 = new Article();
      
      r1.setTitle("title1");
      r1.setArticleAbstract("aa1");
      r1.setKeywords("keywords1");
      r1.setAuthor("author1");
      r1.setVerified(Boolean.TRUE);
      r1.setPublsihed(Boolean.TRUE);
      r1.setCitedCount(1);
      r1.setContributedBy("cb1");
      r1.setVerifiedBy("vb1");
      r1.setTimesFlagged(0);
      r1.setDate(Date.from(Instant.MIN));
      
      r2 = new Article();
      
      r2.setTitle("title2");
      r2.setArticleAbstract("aa2");
      r2.setKeywords("keywords2");
      r2.setAuthor("author2");
      r2.setVerified(Boolean.TRUE);
      r2.setPublsihed(Boolean.TRUE);
      r2.setCitedCount(1);
      r2.setContributedBy("cb2");
      r2.setVerifiedBy("vb2");
      r2.setTimesFlagged(0);
      r2.setDate(Date.from(Instant.MIN));
      
      r4 = new Article();
      r4.setTitle("title4");
      r4.setArticleAbstract("aa4");
      r4.setKeywords("keywords4");
      r4.setAuthor("author4");
      r4.setVerified(Boolean.TRUE);
      r4.setPublsihed(Boolean.TRUE);
      r4.setCitedCount(1);
      r4.setContributedBy("cb2");
      r4.setVerifiedBy("vb2");
      r4.setTimesFlagged(0);
      r4.setDate(Date.from(Instant.MIN));
      
      

      u1 = new User();
      
      u1.setUsername("username1");
      u1.setFirstName("fn1");
      u1.setLastName("ln1");
      u1.setEmail("email1");
      u1.setPassword("password1");
      u1.setDob("dob1");
      u1.setGender("gender1");
      u1.setInstitution("instit1");
      u1.setDeptName("dn1");
      u1.setFieldResearch("fr1");
      u1.setRoleId(1234);
      
      u2 = new User();
      
      u2.setUsername("username2");
      u2.setFirstName("fn2");
      u2.setLastName("ln2");
      u2.setEmail("email2");
      u2.setPassword("password2");
      u2.setDob("dob2");
      u2.setGender("gender2");
      u2.setInstitution("instit2");
      u2.setDeptName("dn2");
      u2.setFieldResearch("fr2");
      u2.setRoleId(123);
      
      
      u4 = new User();
      
      u4.setUsername("username2");
      u4.setFirstName("fn2");
      u4.setLastName("ln2");
      u4.setEmail("email2");
      u4.setPassword("password2");
      u4.setDob("dob2");
      u4.setGender("gender2");
      u4.setInstitution("instit2");
      u4.setDeptName("dn2");
      u4.setFieldResearch("fr2");
      u4.setRoleId(431);
      
      
      v1 = new Verifier();
      v2 = new Verifier();
      
      r.addArticle(r1);
      r.addArticle(r2);

      u.addAccount(u1);
      u.addAccount(u2);
      u.addAccount(u4);
      
      d.upgradeVerifier(v1);
      d.upgradeVerifier(v2);
      
      
    }
    
    @AfterEach
    public void tearDown() {
      v.deleteArticle(r1.getArticleId());
      v.deleteArticle(r2.getArticleId());
      
      u.deleteAccount(u1);
      u.deleteAccount(u2);
      u.deleteAccount(u4);
      
      d.demoteVerifier(v1);
      d.demoteVerifier(v2);
    }
    
    @Test
    public void testUpgradeVerifier() {
      d.upgradeVerifier(v1);
      assertThat(d.getVerifiers(v1), hasSize(1));
      assertThat(d.getVerifiers(), hasItem(v1)));

    }
    
    @Test
    public void testDemoteVerifier() {
      d.demoteVerifier(v1);
      assertThat(v.getVerifiers(), hasSize(1));
      assertThat(v.getVerifiers(), not(hasItem(v1)));
    }
    
    
  }
