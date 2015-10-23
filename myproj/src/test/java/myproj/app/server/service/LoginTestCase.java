package myproj.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import myproj.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import myproj.app.server.repository.LoginRepository;
import myproj.app.shared.authentication.Login;
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
import myproj.app.shared.contacts.CoreContacts;
import myproj.app.server.repository.CoreContactsRepository;
import myproj.app.shared.contacts.Gender;
import myproj.app.server.repository.GenderRepository;
import myproj.app.shared.location.Language;
import myproj.app.server.repository.LanguageRepository;
import myproj.app.shared.location.Timezone;
import myproj.app.server.repository.TimezoneRepository;
import myproj.app.shared.contacts.Title;
import myproj.app.server.repository.TitleRepository;
import myproj.app.shared.authentication.User;
import myproj.app.server.repository.UserRepository;
import myproj.app.shared.authentication.UserAccessDomain;
import myproj.app.server.repository.UserAccessDomainRepository;
import myproj.app.shared.authentication.UserAccessLevel;
import myproj.app.server.repository.UserAccessLevelRepository;

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
            corecontacts.setAge(122);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("TVX8DTSObgkDrPrlPWTjKn7EiC4zAyrjjcoRWcCGI9waqp1bLi");
            corecontacts.setFirstName("eWFPWnNlWVonotWOWrD6KUDnEQlsziIaFRQzaf8ytvYTNpoOR1");
            Gender gender = new Gender();
            gender.setGender("A6pFiuV1dGdtb2e5xr6lzFUOPCd3uNCHMwa8QTpuykNOkCek1m");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("ko");
            language.setAlpha3("tLC");
            language.setAlpha4("by6N");
            language.setAlpha4parentid(7);
            language.setLanguage("VeSfKSS130USBjRdhAjTbcGFupXsVkD0iwLZphVbfh00aJ4YTO");
            language.setLanguageDescription("GpSHMQGiQst0rqZh4q0hbRhk0nOh1KETTa0U6xNHNNKZjrKTcy");
            language.setLanguageIcon("QbtljrCBQots7Wa6d6uv6xlMjpVz6ouSZq3zJuflhJ23ohur7z");
            language.setLanguageType("6pQsQwS1X7gJ0efVtpsZgo1DsuTbsXh8");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("9x2BxO1YXMUUa5GIlHS2K7a8LGu8Vg7cCy7PVNQXcHdwDgki9r");
            timezone.setCountry("xYPDl0qavQdKET3RRKfG2Bw2jxGTF9x7dIe4ICuBVTjdPfQmHa");
            timezone.setGmtLabel("nN20IboJsdNVc3vcT1mfTJT0O5sY4nOHX5ifkDnxSKK0RDpZr7");
            timezone.setTimeZoneLabel("IsOBe03CvU1W3VtloXSoh4jcd1udUm1TBCw1GxohAdjnWg1SQw");
            timezone.setUtcdifference(8);
            Timezone TimezoneTest = timezoneRepository.save(timezone);
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            Title title = new Title();
            title.setTitles("WaNgqkR27Nh1Bhc3zHiZ8w02IE4Ke6coy9MuPx6sZ5kTMwJE7f");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(115);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("E3sXBQvElVHSRcWXuxjc7Ks8sxL11R1ONFcLOKCqZiDE8jlaH4");
            corecontacts.setFirstName("wrIab7DQY2Sm6SmURGeBrnd7acvdIrzRGwrJ3BSBCjwnBKBa4m");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("M5so0Pl1WgenhftcUsTezwGlGfAUESTsAk6WrWd93oHwQG0Jzv");
            corecontacts.setMiddleName("pbIKyELLfaehzi0bwkXxedC2Oe7LwDc2SqZ61MyrylaM6hVXAP");
            corecontacts.setNativeFirstName("LP5Ue0IrrwoA3TAbPrtGmmKut4Sa7HRoZAJCj1j0URRyr3k2h5");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("MvtCBThoGVgAN65RrfIIy2fbwGV6LviPqv5pwP5nYsIY2P9p94");
            corecontacts.setNativeMiddleName("9H27ak0E3ECehV36svBRNEIfSD2g9k4KFAnuAo0XOpHcEtMejZ");
            corecontacts.setNativeTitle("x6cWF2eFaRZ9u1XN1MOLKM2OVRDMdSYGFgDJN5F1r9zivujKfp");
            corecontacts.setPhoneNumber("Ngg0QHYLurPJ3kjrIyqu");
            corecontacts.setTimeZone((java.lang.String) TimezoneTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            User user = new User();
            user.setAllowMultipleLogin(1);
            user.setChangePasswordNextLogin(0);
            user.setGenTempOneTimePassword(0);
            user.setIsDeleted(0);
            user.setIsLocked(1);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(0);
            user.setPasswordAlgo("Ubk9b9RaPpuqS9SNWFNofP2UvfRU2ZM95hY3BbLOgLJ0lVOzLw");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(2418);
            user.setUserAccessCode(8);
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setDomainDescription("ReuzGoVfAAAvG5RhwiA9hBJ9htRj9nijm2X1fthrxivlcWzG36");
            useraccessdomain.setDomainHelp("h5XgHjiB2VUauMxbeQZYVY6324UJnjrvOtyT3f0ykq5X2xMaiE");
            useraccessdomain.setDomainIcon("SISYbrVaVBcHSzkHRrnfoQvqqxFOANULBnpQGDGq8eWFNYlyxb");
            useraccessdomain.setDomainName("G5jsQCQPLps1dgZQkHGd4ZCRUrdEWbgBGKnq2DwpkLjg8sjnMN");
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setLevelDescription("0KfLJCSLu9pE7Sf82R7QZh0PBWqWQRXBHsyQHjrMCbadl2rCO9");
            useraccesslevel.setLevelHelp("mJjQBRHH448rnLOgWjW5hLRmxXYaGW1UX0sbw8OXE2sanjOC1f");
            useraccesslevel.setLevelIcon("LexOlURPf9qgyq6aKXRyIYVxAXnak4IpMkkBhVUC3SweLz8gUc");
            useraccesslevel.setLevelName("obHcigNV2unk5zZKoElr7sRvy2ovohovXC7MpNOxtiaEC1fNJA");
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            user.setAllowMultipleLogin(1);
            user.setChangePasswordNextLogin(0);
            user.setGenTempOneTimePassword(0);
            user.setIsDeleted(1);
            user.setIsLocked(0);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(0);
            user.setPasswordAlgo("iJhSsjrX1KgxPPDtmcA5RPM33Oae1I4wcKA6WaiKla9hMEjvq6");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(904);
            user.setUserAccessCode(7);
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey());
            Login login = new Login();
            login.setCoreContacts(corecontacts);
            login.setFailedLoginAttempts(4);
            login.setIsAuthenticated(true);
            login.setLoginId("a14zhLUJiIthHAxae1NEX08VizLAZnkPYcGNpoIQLf2qZ5008t");
            login.setServerAuthImage("9ioIQV2rfGEo4HEanOEslFU14ICCX1bO");
            login.setServerAuthText("JEGmFYFbmAiKprgk");
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
            login.setFailedLoginAttempts(8);
            login.setLoginId("VIUZ3zURSUKvmwMr8CB6boxgj0uS91aaS4okrx7O1APs14KlRx");
            login.setServerAuthImage("zc8fxWWQITUepgaEUzDGmUnhcJqVzlij");
            login.setServerAuthText("i0pxZozE8mDnqc9C");
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
    public void testNQFindMappedUser() {
        try {
            loginRepository.FindMappedUser();
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
