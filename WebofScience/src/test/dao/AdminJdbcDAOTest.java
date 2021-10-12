
import dao.AdminJdbcDAO;
import dao.ArticleJdbcDAO;
import dao.UserJdbcDAO;
import dao.VerifierJdbcDAO;
import domain.Admin;
import domain.Article;
import domain.User;
import domain.Verifier;
import static java.util.function.Predicate.not;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;

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
    
    public AdminJdbcDAOTestst() {
    }
    
    @BeforeEach
    public void setUp() {
      
      r1 = new Article();
      
      r1.setTitle("title1");
      r1.setArticleAbstract("aa1");
      r1.setFile("file1");
      r1.setKeywords("keywords1");
      r1.setAuthor("author1");
      r1.setVerified("verified1");
      r1.setPublished("pub1");
      r1.setCitedCount("cc1");
      r1.setContributedBy("cb1");
      r1.setVerifiedBy("vb1");
      r1.setTimesFlagged("tf1");
      r1.setDate("date1");
      
      r2 = new Article();
      
      r2.setTitle("title2");
      r2.setArticleAbstract("aa2");
      r2.setFile("file2");
      r2.setKeywords("keywords2");
      r2.setAuthor("author2");
      r2.setVerified("verified2");
      r2.setPublished("pub2");
      r2.setCitedCount("cc2");
      r2.setContributedBy("cb2");
      r2.setVerifiedBy("vb2");
      r2.setTimesFlagged("tf2");
      r2.setDate("date2");
      
      r4 = new Article();
      r4.setTitle("title4");
      r4.setArticleAbstract("aa4");
      r4.setFile("file4");
      r4.setKeywords("keywords4");
      r4.setAuthor("author4");
      r4.setVerified("verified4");
      r4.setPublished("pub4");
      r4.setCitedCount("cc4");
      r4.setContributedBy("cb4");
      r4.setVerifiedBy("vb4");
      r4.setTimesFlagged("tf4");
      r4.setDate("date4");
      
      
      
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
      u1.setRoleId("ri1");
      
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
      u2.setRoleId("ri2");
      
      
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
      u2.setRoleId("ri2");
      
      
      r.saveArticle(r1);
      r.saveArticle(r2);
      
      u.saveUser(r1);
      u.saveUser(r2);
      
      u.saveUser(r4);
      
      
    }
    
    @AfterEach
    public void tearDown() {
      r.removeArticle(r1);
      r.removeArticle(r2);
      
      u.removeUser(u1);
      u.removeUser(u2);
      u.removeUser(u4);
      
    }
    
    @Test
    public void testAddArticle() {
      r.addArticle(r1);
      assertThat(r.getArticles(r1), hasSize(1));
      assertThat(r.getArticles(), hasItem(r1)));
    }
    
    @Test
    public void testDeleteArticle() {
      r.deleteArticle(r1);
      assertThat(r.getArticles(), hasSize(1));
      assertThat(r.getArticles(), not(hasItem(r1)));
    }
  }
