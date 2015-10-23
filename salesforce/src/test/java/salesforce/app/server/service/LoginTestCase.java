package salesforce.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import salesforce.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import salesforce.app.server.repository.LoginRepository;
import salesforce.app.shared.authentication.Login;
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
import salesforce.app.shared.contacts.CoreContacts;
import salesforce.app.server.repository.CoreContactsRepository;
import salesforce.app.shared.contacts.Gender;
import salesforce.app.server.repository.GenderRepository;
import salesforce.app.shared.location.Language;
import salesforce.app.server.repository.LanguageRepository;
import salesforce.app.shared.location.Timezone;
import salesforce.app.server.repository.TimezoneRepository;
import salesforce.app.shared.contacts.Title;
import salesforce.app.server.repository.TitleRepository;
import salesforce.app.shared.authentication.User;
import salesforce.app.server.repository.UserRepository;
import salesforce.app.shared.authentication.UserAccessDomain;
import salesforce.app.server.repository.UserAccessDomainRepository;
import salesforce.app.shared.authentication.UserAccessLevel;
import salesforce.app.server.repository.UserAccessLevelRepository;

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
            corecontacts.setAge(44);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("3xoCmhTg02yqvaN8Ipk0xliE9BvdZadWaLx0HGO0pO10IoNNx7");
            corecontacts.setFirstName("Hyz5RxMixrenOosCoY84RmnjZOQzEEVcUxwmQ9HMWpJu7yjvZQ");
            Gender gender = new Gender();
            gender.setGender("HOxFwKSuINMJRAVfgo8brG5TO37BL6TYges65pv4a2q0LkLeT7");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("ZO");
            language.setAlpha3("Rv4");
            language.setAlpha4("K5W3");
            language.setAlpha4parentid(10);
            language.setLanguage("qFcQlhMHlcyFuk3uoVW4IYerEnl1KjWwwnMEP6k2Ivt5xGLgXF");
            language.setLanguageDescription("IwcistjdGXqXmUI97Gdl728zIXti1IS8QGdvqSz8bSNHoW58eO");
            language.setLanguageIcon("Zgpux4A3SwENL3ghLnRBofqIzwgs1Som3u4jiPP8yrS8mBYS1d");
            language.setLanguageType("nC8meJAqXemIgO4DY8GzFc23kjn4baTr");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("2mWPeXyO0geEAflIoAaBxL6OUkaDEBJH7aG4UmvMoD1Eu1oTJb");
            timezone.setCountry("O6mCS94wk5nTx7xZ6PgVNHJidjtmfbxMlCWJMKhv81a7QYWQx0");
            timezone.setGmtLabel("bs635AAz4xFcm2PrAnoQFhEnx7K5SC0fFv716iFkSL0B4aPPVa");
            timezone.setTimeZoneLabel("HVmPrYgiipsyEAWs6CUlnWekNgCNchXI7gHObtY8Y3o6Hsk7yG");
            timezone.setUtcdifference(11);
            Timezone TimezoneTest = timezoneRepository.save(timezone);
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            Title title = new Title();
            title.setTitles("djNVhejI5qNFSujxjUj27XWSLoeRRx4RUG0NSJwxjzzB3QFsti");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(71);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("YZsSBbGRl8ctKsE2b4mcSck6wMmgHbnVAYogSVSOolImHkB0MW");
            corecontacts.setFirstName("rYDXL9h2E2lhh9qbxUHYP6yYaeTNCqeyH1XLZnE1RmVRjBzUsO");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("4yIqTWHibCRu6s9p9y9D97WQw6rItszNP7c9TF2RxttKpG7Pf4");
            corecontacts.setMiddleName("FB0QsfFmJO6RW0BtFT1PiIENswGeVWv4BM5N8FaVUs6PZbsUbg");
            corecontacts.setNativeFirstName("gC9JB2ZbiOwDECZ7INn9toj57lrTKVEMcPdzjCAHc5LZalvDzu");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("8cUYE1hlReNes4BtTkDthAkRnhajiziToHkGX43GJ2rZG1Snpq");
            corecontacts.setNativeMiddleName("7Biu8jFxrwYUGcHJdPSOG791nc1v9Z0UwMf1nhqME0B5Z6W4O5");
            corecontacts.setNativeTitle("UsK0jnbwwGEVCpeTAkGSaRlOKaMx1mRROIcK7pLd0WY7TdVgY7");
            corecontacts.setPhoneNumber("Pi9ftjLI30fM703UOtt0");
            corecontacts.setTimeZone((java.lang.String) TimezoneTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            User user = new User();
            user.setAllowMultipleLogin(1);
            user.setChangePasswordNextLogin(0);
            user.setGenTempOneTimePassword(0);
            user.setIsDeleted(0);
            user.setIsLocked(0);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(1);
            user.setPasswordAlgo("a78CGKm0rTGNPo29NLUCTnQSVUTzMkNpWiYebwXA91YZEqs3XS");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(3019);
            user.setUserAccessCode(0);
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setDomainDescription("yakcH8KSmF3IZ2tNbJVt2iDJPfDmzj2mop4gyXqt1b7P84ADsz");
            useraccessdomain.setDomainHelp("fyvbG4ZKz9z74Ocpzapun5dPZn5upZgm41UJJdhXkZhAnPNF2H");
            useraccessdomain.setDomainIcon("zNkCY2NLWvEyBKv6XsOcu8pUH1Mp5VbD3GVBL04DFv1DHnQDhc");
            useraccessdomain.setDomainName("E9eH5XND2baqYwbOvYn3x0FqMJ3pZmYMNe17zoU1V4Nl0WVZSE");
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setLevelDescription("4An5UuFQ6C1ZC2HgNg95YsoLpGT3CNsitzl1zHsrmyYgy3p1bE");
            useraccesslevel.setLevelHelp("ioa8ODT68CENfv8s2BQyiuSbskH1XYrqU1HQjfLstVzFEegSnF");
            useraccesslevel.setLevelIcon("nG7NMezdH4MYzUeH5zSEZFzukbJ3csd6pKOcsBPzOc6SDGE4oD");
            useraccesslevel.setLevelName("nwCxuJmipteWFiIeGp6sfO7lZKi03SuKEw7qXgxiyPeV171Izn");
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            user.setAllowMultipleLogin(0);
            user.setChangePasswordNextLogin(0);
            user.setGenTempOneTimePassword(0);
            user.setIsDeleted(0);
            user.setIsLocked(0);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(0);
            user.setPasswordAlgo("XkkOoiKRnsQYw72IFXUXVa8mu47GAgtLaQ0WHRG07JvgLgkJpa");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(547);
            user.setUserAccessCode(7);
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey());
            Login login = new Login();
            login.setCoreContacts(corecontacts);
            login.setFailedLoginAttempts(6);
            login.setIsAuthenticated(true);
            login.setLoginId("xq439AM5CLzF4mxJcFCDP9fLcxQf1PlFiQj2tS1XuY6bQzzNjl");
            login.setServerAuthImage("WrOnGvujQ1Xh9jHCIRzln04AwZoFbhuJ");
            login.setServerAuthText("h0Bvyh4bQKD8GvXy");
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
            login.setFailedLoginAttempts(6);
            login.setLoginId("usROY2DxNJsPQAAlz0bpB94G1TMR4y08WMJGxqS7JkW3H6NPWc");
            login.setServerAuthImage("fVVS53WBGFJNuvCk8OHPoqsaSdXCAt0o");
            login.setServerAuthText("82xzYkFccpMwzpgj");
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
