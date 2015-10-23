package project.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import project.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import project.app.server.repository.LoginRepository;
import project.app.shared.authentication.Login;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.athena.framework.server.helper.EntityValidatorHelper;
import com.athena.framework.server.test.RandomValueGenerator;
import java.util.HashMap;
import com.spartan.healthmeter.entity.scheduler.ArtMethodCallStack;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.junit.Before;
import org.junit.After;
import com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;
import project.app.shared.contacts.CoreContacts;
import project.app.server.repository.CoreContactsRepository;
import project.app.shared.contacts.Gender;
import project.app.server.repository.GenderRepository;
import project.app.shared.location.Language;
import project.app.server.repository.LanguageRepository;
import project.app.shared.location.Timezone;
import project.app.server.repository.TimezoneRepository;
import project.app.shared.contacts.Title;
import project.app.server.repository.TitleRepository;
import project.app.shared.authentication.User;
import project.app.server.repository.UserRepository;
import project.app.shared.authentication.UserAccessDomain;
import project.app.server.repository.UserAccessDomainRepository;
import project.app.shared.authentication.UserAccessLevel;
import project.app.server.repository.UserAccessLevelRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class LoginTestCase {

    @Autowired
    private LoginRepository<Login> loginRepository;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private EntityValidatorHelper<Object> entityValidator;

    private RandomValueGenerator valueGenerator = new RandomValueGenerator();

    private static HashMap<String, Object> map = new HashMap<String, Object>();

    @Autowired
    private ArtMethodCallStack methodCallStack;

    protected MockHttpSession session;

    protected MockHttpServletRequest request;

    protected MockHttpServletResponse response;

    protected void startSession() {
        session = new MockHttpSession();
    }

    protected void endSession() {
        session.clearAttributes();
        session.invalidate();
        session = null;
    }

    protected void startRequest() {
        request = new MockHttpServletRequest();
        request.setSession(session);
        org.springframework.web.context.request.RequestContextHolder.setRequestAttributes(new org.springframework.web.context.request.ServletRequestAttributes(request));
    }

    protected void endRequest() {
        ((org.springframework.web.context.request.ServletRequestAttributes) org.springframework.web.context.request.RequestContextHolder.getRequestAttributes()).requestCompleted();
        org.springframework.web.context.request.RequestContextHolder.resetRequestAttributes();
        request = null;
    }

    @Before
    public void before() {
        startSession();
        startRequest();
        setBeans();
    }

    @After
    public void after() {
        endSession();
        endRequest();
    }

    private void setBeans() {
        runtimeLogInfoHelper.createRuntimeLogUserInfo(1, "AAAAA", request.getRemoteHost());
        org.junit.Assert.assertNotNull(runtimeLogInfoHelper);
        methodCallStack.setRequestId(java.util.UUID.randomUUID().toString().toUpperCase());
    }

    @Test
    public void test1Save() {
        try {
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(102);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("vKNxkOXusfGvP5Ddtwn1dktFlK6FFIHLq4TtRsLymXXDgpfxLW");
            corecontacts.setFirstName("7xaKyuNeMQTC3Fkoyr5LqDqkxOs4HzylxvzTn6osDKRMFCcMLH");
            Gender gender = new Gender();
            gender.setGender("s2j3WAOsmqEvGtr1Ns9RGnRsWcCbUYhKp9gtQJ8QwcNQtPatqR");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("w1");
            language.setAlpha3("ctH");
            language.setAlpha4("TbQA");
            language.setAlpha4parentid(2);
            language.setLanguage("UwIDJOMy9qyxO5ZsB2bUKXnPFOoVAApM98dfH3wNNEkYqi6HNP");
            language.setLanguageDescription("nbjwkYEBzWULZ4wK5jbQemtokWGHIbaFJZy1ZR3tSBxN907y1k");
            language.setLanguageIcon("LWxPVTpo2saUMptdqN3EQbojEVymd8lydAmGsafho0hmyJtygN");
            language.setLanguageType("2XtR7mKlN4o3JGiGGOWOIuo9gwGHvxii");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("zCyNv6TgY3x3mQs1rp2qAPXFC9CfdX8fUKaF69AWmE3c6bDl6d");
            timezone.setCountry("0J0UkuZ4yqGgkybn2qiIAYaLSnSHBWxOQganhpha1cRFABbhv6");
            timezone.setGmtLabel("ekEcTOJdnwie12FAf8tN46uIW9Tidgz1R3IG2Vd59wRrtHRQOJ");
            timezone.setTimeZoneLabel("dzT99Qx3MjDqCcHJbKvrq7QfYWmrk0X6KQWw8jUvmlZKwPZRXn");
            timezone.setUtcdifference(3);
            Timezone TimezoneTest = timezoneRepository.save(timezone);
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            Title title = new Title();
            title.setTitles("ofBnbAcrpD2lDLHA3X88fo6SEHCVv07BM6iI9Q222E91d2jt5K");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(81);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("enIAZ3HaKojiSkdA8xVcfZJAYdYhkDi7fkimJ4JlyJLlQUhkRz");
            corecontacts.setFirstName("68ySCS9MYXvZvzlP9aOSNvVLBG6AwTAFnVVFC1r3uHMLLpj5H5");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("U4ferRipgFLuR62DUqEF9fq6jtSPLsBVdqaOUVg9fBL66KDm5O");
            corecontacts.setMiddleName("4iu7pyurgR7f5lVebtjz19yXyBOVaIWnXkQeDW5aaOphCHmIAl");
            corecontacts.setNativeFirstName("OpPLMDlD3rFf9EmvQrmaVnNJRdcKO9SAxMgnCqVrNdeWkDSjFx");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("gA87ANKKrtAgvlgheCV7mg66cKf59FLEWSrc5LRzGTCFDmeDZC");
            corecontacts.setNativeMiddleName("dtODUGCYUCjW2QaPiOojTi7qvu4IJtEFN41Ap9DkZjqDLlDH2s");
            corecontacts.setNativeTitle("fmaYwGnHrCTywzEGXGLPeukbltCDDqLSm4mcoJACkrVm2iqEuI");
            corecontacts.setPhoneNumber("NEkA7aodWadAjwpaSWha");
            corecontacts.setTimeZone((java.lang.String) TimezoneTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            User user = new User();
            user.setAllowMultipleLogin(0);
            user.setChangePasswordNextLogin(0);
            user.setGenTempOneTimePassword(1);
            user.setIsDeleted(0);
            user.setIsLocked(1);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(0);
            user.setPasswordAlgo("burjOFO1LJT7cwxYPDplfIXErxERgnLIMlA5EmfHM73AEVKXIh");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(606);
            user.setUserAccessCode(11);
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setDomainDescription("8Qo24IryHWmOWmXyMZyi0MB0KdTzBeqxKADp3Q1LhY3CoSFD3d");
            useraccessdomain.setDomainHelp("hwgHTzrLvZ4ENhGk9yWc7nib2ZqDkpqW7bge9YXykxvI6IvKmw");
            useraccessdomain.setDomainIcon("t0cb4dHqL5eRtuLrlBzKNFEKEfRIeuvyk2dH0fIRrhi5nWpteL");
            useraccessdomain.setDomainName("aFcmYTEsvv7R0OaOsgEXe2mamBKkuT5hnb7XpVeb1MMn6FUoyY");
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setLevelDescription("Kz1M9XNmgOJmf5d2jFTA3MuO220l2gfGFkmgiwFId1AZR4fW4c");
            useraccesslevel.setLevelHelp("rRhAZ7I9Qk4SoGruVyItboRBKMT9ggaesZWjlEoaVdf0lRLI1n");
            useraccesslevel.setLevelIcon("0RLrCCGUtY1AETkYgb57ktGdwgnAN0SeukqfM14ouY5uDcMBgc");
            useraccesslevel.setLevelName("FfkNBu3GpfRIpTpGymWW29hQd0DUCEVZ3mnn049nIaGGd8zdGP");
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            user.setAllowMultipleLogin(1);
            user.setChangePasswordNextLogin(1);
            user.setGenTempOneTimePassword(0);
            user.setIsDeleted(0);
            user.setIsLocked(0);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(1);
            user.setPasswordAlgo("ciflVSIyEMAQCetgH9kOuXaCkpbpDTpEDo1OeeWyMlnIoEqLJv");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(3561);
            user.setUserAccessCode(0);
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey());
            Login login = new Login();
            login.setCoreContacts(corecontacts);
            login.setFailedLoginAttempts(11);
            login.setIsAuthenticated(true);
            login.setLoginId("RknjtcPQCBrB71bsMoUpUX7WjTPuXB82QcSiMHIFx7sBy0vPNg");
            login.setServerAuthImage("cC78fasvxRBCroaY7I8XVUn21yLFjTwf");
            login.setServerAuthText("0RdDXtuzGXDaz8Zz");
            login.setUser(user);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            login.setEntityValidator(entityValidator);
            login.isValid();
            loginRepository.save(login);
            map.put("LoginPrimaryKey", login._getPrimarykey());
            map.put("CoreContactsPrimaryKey", login.getCoreContacts()._getPrimarykey());
            map.put("UserPrimaryKey", login.getUser()._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private UserRepository<User> userRepository;

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            Login login = loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
            login.setFailedLoginAttempts(4);
            login.setLoginId("FtY0ou7wqciIaz2ZEsl5R7L4JysLRsjEWYOEiFsnaoAvmLWbLI");
            login.setServerAuthImage("cIBOnKWbAehCiFqyKWf4Ix662SBDEQa4");
            login.setServerAuthText("66r916niHHk8Gq68");
            login.setVersionId(1);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            loginRepository.update(login);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findBycontactId() {
        try {
            java.util.List<Login> listofcontactId = loginRepository.findByContactId((java.lang.String) map.get("CoreContactsPrimaryKey"));
            if (listofcontactId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findByuserId() {
        try {
            java.util.List<Login> listofuserId = loginRepository.findByUserId((java.lang.String) map.get("UserPrimaryKey"));
            if (listofuserId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testNQFindUnMappedUser() {
        try {
            loginRepository.FindUnMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testNQFindMappedUser() {
        try {
            loginRepository.FindMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.delete((java.lang.String) map.get("LoginPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
