import advertiser.controller.AdvertiserController;
import advertiser.model.Advertiser;
import advertiser.service.AdvertiserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.*;

public class AdvertiserControllerTests extends AbstractTest {
    final int ID = 1;
    final String NAME = "Test 1";
    final String CONTACTNAME = "Test Contact 1";
    final int CREDITLIMIT = 500;

    @Override
    @Before
    public void setUp() {
        super.setUp();
        try {
            createTestAdvertiser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createTestAdvertiser() throws Exception {
        Advertiser advertiser = createAdvertiser();
        String uri = "/api/advertiser";
        String inputJson = "";
        inputJson = mapToJson(advertiser);
        mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
    }

    private Advertiser createAdvertiser() {
        Advertiser advertiser = new Advertiser();
        advertiser.setName(NAME);
        advertiser.setContactName(CONTACTNAME);
        advertiser.setCreditLimit(CREDITLIMIT);
        return advertiser;
    }

    @Mock
    AdvertiserService service;

    @InjectMocks
    private AdvertiserController advertiserController;

    @Test
    public void testGetAdvertisers() throws Exception {

        String uri = "/api/advertiser";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Advertiser[] advertisers = mapFromJson(content, Advertiser[].class);
        assertTrue(advertisers.length > 0);
        assertFalse(advertisers.length <= 0);
    }

    @Test
    public void testUpdateAdvertiser() throws Exception {
        String uri = "/api/advertiser";
        Advertiser advertiser = new Advertiser();
        String inputJson = super.mapToJson(advertiser);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
        		.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(404, status);
    }

    @Test
    public void testCreateAdvertiser() throws Exception {
        Advertiser advertiser = new Advertiser();
        String uri = "/api/advertiser";
        String inputJson = super.mapToJson(advertiser);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "");
    }

    @Test
    public void testDeleteAdvertiser() throws Exception {
        String uri = "/api/advertiser/{id}";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri, 1)
                .accept(MediaType.APPLICATION_JSON)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    public void testGetAdvertiser() throws Exception {
        String uri = "/api/advertiser/{id}";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri, 1)
                .accept(MediaType.APPLICATION_JSON)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Advertiser advertiser = mapFromJson(content, Advertiser.class);
        assertEquals(advertiser.getId(), ID);
        assertEquals(advertiser.getName(), NAME);
        assertEquals(advertiser.getContactName(), CONTACTNAME);
        assertEquals(advertiser.getCreditLimit(), CREDITLIMIT);
    }
}