package ApiTests;

import ApiTests.Backend.*;
import UsedByAll.Config;
import UsedByAll.CsvUsersReader;
import UsedByAll.RegionMatch;
import UsedByAll.TestUser;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class BackendAPITest {
    @Test
    public void runBackendAPITests() throws Exception {
        Config config = Config.getConfig();
        String siteUrl = config.getProtocol() + config.getScheme(); // Урл проверяемого сайта
        TestUser[] testUser = new CsvUsersReader().getUsersFromFile("src/Users.csv");
        boolean isComplete = true;
        for (TestUser aTestUser : testUser) {
            if (RegionMatch.IsStringRegionMatch(aTestUser.getUseInTest(), "_BackendAPITest(")) {
                // GET API users test run
                if (new GetUsers().testGetUsers(siteUrl, aTestUser)) {
                    System.out.println("API GET users success");
                } else {
                    System.out.println("API GET users test FAILED ");
                    isComplete = false;
                }

                // GET API accounts test run
                if (new GetAccounts().testGetAccounts(siteUrl, aTestUser)) {
                    System.out.println("API GET accounts success");
                } else {
                    System.out.println("API GET accounts test FAILED ");
                    isComplete = false;
                }

                // PUT API accounts update test run
                if (new PutAccountsUpdate().testPutAccountsUpdate(siteUrl, aTestUser)) {
                    System.out.println("API PUT accounts update success");
                } else {
                    System.out.println("API PUT accounts update test FAILED ");
                    isComplete = false;
                }

                //GET API operations test run
                if (new GetOperations().testGetOperations(siteUrl, aTestUser)) {
                    System.out.println("API GET operations success");
                } else {
                    System.out.println("API GET operations test FAILED ");
                    isComplete = false;
                }

                // PUT API operations update test run
                if (new PutOperationsUpdate().testPutOperationsUpdate(siteUrl, aTestUser)) {
                    System.out.println("API PUT operations update success");
                } else {
                    System.out.println("API PUT operations update test FAILED ");
                    isComplete = false;
                }

                // POST API operation insert test run
                if (new PostOperationInsert().testPostOperationInsert(siteUrl, aTestUser)) {
                    System.out.println("API POST operation insert success");
                } else {
                    System.out.println("API POST operation insert test FAILED ");
                    isComplete = false;
                }

                // GET API purchases test run
                if (new GetPurchases().testGetPurchases(siteUrl, aTestUser)) {
                    System.out.println("API GET Purchases success");
                } else {
                    System.out.println("API GET Purchases test FAILED ");
                    isComplete = false;
                }
                //PUT API Purchases test run
                if (new PutPurchasesUpdate().testPutPurchasesUpdate(siteUrl, aTestUser)) {
                    System.out.println("API PUT purchases update success");
                } else {
                    System.out.println("API PUT purchases update test FAILED ");
                    isComplete = false;
                }

                //POST API Purchases test run
                if (new PostPurchasesInsert().testPostPurchasesInsert(siteUrl, aTestUser)) {
                    System.out.println("API POST purchases insert success");
                } else {
                    System.out.println("API POST purchases insert test FAILED ");
                    isComplete = false;
                }

                // GET API withdraws test run
                if (new GetWithdraws().testGetWithdraws(siteUrl, aTestUser)) {
                    System.out.println("API GET withdraws success");
                } else {
                    System.out.println("API GET withdraws test FAILED ");
                    isComplete = false;
                }

                // PUT API withdraws update test run
                if (new PutWithdrawsUpdate().testPutWithdrawsUpdate(siteUrl, aTestUser)) {
                    System.out.println("API PUT withdraws update success");
                } else {
                    System.out.println("API PUT withdraws update test FAILED ");
                    isComplete = false;
                }

                // POST API withdraw insert test run
                if (new PostWithdrawInsert().testPostWithdrawInsert(siteUrl, aTestUser)) {
                    System.out.println("API POST withdraw insert success");
                } else {
                    System.out.println("API POST withdraw insert test FAILED ");
                    isComplete = false;
                }
                // GET API products test run
                if (new GetProducts().testGetProducts(siteUrl, aTestUser)) {
                    System.out.println("API GET products success");
                } else {
                    System.out.println("API GET products test FAILED ");
                    isComplete = false;
                }

                // PUT API products update test run
                if (new PutProductsSave().testPutProductsUpdate(siteUrl, aTestUser)) {
                    System.out.println("API PUT products update success");
                } else {
                    System.out.println("API PUT products update test FAILED ");
                    isComplete = false;
                }

                // PUT API products insert test run
                if (new PutProductsSave().testPutProductsInsert(siteUrl, aTestUser)) {
                    System.out.println("API PUT products insert success");
                } else {
                    System.out.println("API PUT products insert test FAILED ");
                    isComplete = false;
                }

                //GET API documents test run
                if (new GetDocuments().testGetDocuments(siteUrl, aTestUser)) {
                    System.out.println("API GET documents success");
                } else {
                    System.out.println("API GET documents test FAILED ");
                    isComplete = false;
                }

                //GET API documents by id test run
                if (new GetDocumentsById().testGetDocumentsById(siteUrl, aTestUser)) {
                    System.out.println("API GET documents GET by ID success");
                } else {
                    System.out.println("API GET documents GET by ID test FAILED ");
                    isComplete = false;
                }

                // GET API config test run
                if (new GetConfig().testGetConfig(siteUrl, aTestUser)) {
                    System.out.println("API GET config success");
                } else {
                    System.out.println("API GET config test FAILED ");
                    isComplete = false;
                }

                // PUT API config update test run
                if (new PutConfigUpdate().testPutConfigUpdate(siteUrl, aTestUser)) {
                    System.out.println("API PUT config update success");
                } else {
                    System.out.println("API PUT config update test FAILED ");
                    isComplete = false;
                }
            }
            assertTrue("BackendAPITests failed", isComplete);
        }
    }
}
