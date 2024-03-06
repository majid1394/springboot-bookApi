package bookApi;

import bookApi.rest.dto.CreateBookRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.client.RestTemplate;


import static io.restassured.RestAssured.port;
import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.http.RequestEntity.post;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//SpringBootTest.WebEnvironment.RANDOM_PORT)" annotation is typically used to start up the Spring application context
// for integration testing with a random port.


//regression test/functional test/sanity test , this run after smoke this
@SpringBootTest/*(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)*/
//@SpringBootTest(properties = {"spring.autoconfigure.exclude=SecurityAutoConfiguration.class"})
@AutoConfigureMockMvc
public class HttpRequestTest {

    @Autowired
    private MockMvc mockMvc;

 /*   @Autowired
    private TestRestTemplate template;

    @Autowired
    private CreateBookRequest createBookRequest;*/

  /*@LocalServerPort
    private int port;*//*  @LocalServerPort
    private int port;*/

/*  @Autowired
    private TestRestTemplate restTemplate;*/

    @Test
    //@WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    void greetingShouldReturnDefaultMessage() throws Exception {
        mockMvc.perform(get("/api/books")
                .with(org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic("admin", "admin")))
                .andExpect(MockMvcResultMatchers.status().isOk());
                     //   .secure(false) // Ignore security
                        /*.contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());*/

        /*String expectedJson = "{\"isbn\": \"9781891830402\", \"title\": \"Beach Safari by Mawil\"}";
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/books",
                String.class)).contains(expectedJson);*/
    }




    @Test
    public void getBook() throws Exception {
       // String expectedJson = "[{\"isbn\":\"9781603094450\",\"title\":\"AShiningBeacon\"},{\"isbn\":\"9781603090773\",\"title\":\"AnyEmpire\"},{\"isbn\":\"9781603090698\",\"title\":\"AugustMoon\"},{\"isbn\":\"9781603090292\",\"title\":\"BBWolfandthe3LP's\"},{\"isbn\":\"9781891830402\",\"title\":\"BeachSafaribyMawil\"},{\"isbn\":\"9781603094429\",\"title\":\"Belzebubs\"},{\"isbn\":\"9781891830563\",\"title\":\"BigheadbyJeffreyBrown\"},{\"isbn\":\"9781603094320\",\"title\":\"Bodycount\"},{\"isbn\":\"9781891830198\",\"title\":\"BoxOfficePoison\"},{\"isbn\":\"9781603094221\",\"title\":\"Cat'n'Bat\"},{\"isbn\":\"9781603091008\",\"title\":\"CraterXV\"},{\"isbn\":\"9781891830815\",\"title\":\"CryYourselftoSleepbyJeremyTinder\"},{\"isbn\":\"9781603092715\",\"title\":\"DearBelovedStranger\"},{\"isbn\":\"9781891830129\",\"title\":\"DearJulia\"},{\"isbn\":\"9781891830921\",\"title\":\"DeathbyChocolate-Redux\"},{\"isbn\":\"9781603090575\",\"title\":\"DragonPuncher(Book1)\"},{\"isbn\":\"9781603090858\",\"title\":\"DragonPuncher(Book2):Island\"},{\"isbn\":\"9781603093873\",\"title\":\"EddieCampbell'sOmnibox:TheCompleteALECandBACCHUS(3VolumeSlipcase)\"},{\"isbn\":\"9781603090360\",\"title\":\"FarArden\"},{\"isbn\":\"9781603090537\",\"title\":\"Fingerprints\"},{\"isbn\":\"9781891830976\",\"title\":\"FoxBunnyFunny\"},{\"isbn\":\"9780958578349\",\"title\":\"FromHell\"},{\"isbn\":\"9781603093866\",\"title\":\"GodIsDisappointed/ApocryphaNow—SLIPCASESET\"},{\"isbn\":\"9781603090988\",\"title\":\"GodIsDisappointedinYou\"},{\"isbn\":\"9781603090087\",\"title\":\"HieronymusB.\"},{\"isbn\":\"9781603094412\",\"title\":\"Highwayman\"},{\"isbn\":\"9781891830174\",\"title\":\"HutchOwen(Vol1):TheCollectedbyTomHart\"},{\"isbn\":\"9781891830556\",\"title\":\"HutchOwen(Vol2):UnmarketablebyTomHart\"},{\"isbn\":\"9781603090865\",\"title\":\"HutchOwen(Vol3):Let'sGetFurious!\"},{\"isbn\":\"9781891830839\",\"title\":\"InfiniteKungFu\"},{\"isbn\":\"9781891830518\",\"title\":\"LessThanHeroesbyDavidYurkovich\"},{\"isbn\":\"9781603090704\",\"title\":\"Liar'sKiss\"},{\"isbn\":\"9781891830693\",\"title\":\"LoneRacerbyNicolasMahler\"},{\"isbn\":\"9781603090094\",\"title\":\"LowerRegions\"},{\"isbn\":\"9781891830334\",\"title\":\"MagicBoyandtheRobotElfbyJamesKochalka\"},{\"isbn\":\"9781891830365\",\"title\":\"MonkeyVs.Robot(Vol2):CrystalofPowerbyKoch.\"},{\"isbn\":\"9781603090759\",\"title\":\"MonsterontheHill(Book1)\"},{\"isbn\":\"9781891830686\",\"title\":\"MosquitobyDanJames\"},{\"isbn\":\"9781603090490\",\"title\":\"MovingPictures\"},{\"isbn\":\"9781603094092\",\"title\":\"NatePowell'sOMNIBOX\"},{\"isbn\":\"9781603090681\",\"title\":\"OkieDokieDonuts(Story1):OpenforBusiness!\"},{\"isbn\":\"9781891830297\",\"title\":\"Pinky&StinkybyJamesKochalka\"},{\"isbn\":\"9781603090711\",\"title\":\"PiratePenguinvsNinjaChicken(Book1):TroublemswithFrenemies\"},{\"isbn\":\"9781603093675\",\"title\":\"PiratePenguinvsNinjaChicken(Book2):EscapefromSkull-FragmentIsland!\"},{\"isbn\":\"9781603094139\",\"title\":\"ReturnoftheDapperMen(DeluxeEdition)\"},{\"isbn\":\"9781603090896\",\"title\":\"SceneButNotHeard\"},{\"isbn\":\"9781891830143\",\"title\":\"Speechless\"},{\"isbn\":\"9781891830501\",\"title\":\"Spiral-BoundbyAaronRenier\"},{\"isbn\":\"9781603090209\",\"title\":\"Sulk(Vol1):BigheadandFriends\"},{\"isbn\":\"9781603090315\",\"title\":\"Sulk(Vol2):DeadlyAwesome\"},{\"isbn\":\"9781603090551\",\"title\":\"Sulk(Vol3):TheKindofStrength...\"},{\"isbn\":\"9781891830969\",\"title\":\"SuperSpy\"},{\"isbn\":\"9781603090438\",\"title\":\"SuperSpy(Vol2):TheLostDossiers\"},{\"isbn\":\"9781603090339\",\"title\":\"SwallowMeWhole\"},{\"isbn\":\"9781603090056\",\"title\":\"ThatSaltyAir\"},{\"isbn\":\"9781891830372\",\"title\":\"TheBarefootSerpent(softcover)byScottMorse\"},{\"isbn\":\"9781891830655\",\"title\":\"TheKingbyRichKoslowski\"},{\"isbn\":\"9781603094375\",\"title\":\"TheLeagueofExtraordinaryGentlemen(VolIII):Century\"},{\"isbn\":\"9781603090001\",\"title\":\"TheLeagueofExtraordinaryGentlemen(VolIII):Century#1-1910\"},{\"isbn\":\"9781603090063\",\"title\":\"TheLeagueofExtraordinaryGentlemen(VolIII):Century#2-1969\"},{\"isbn\":\"9781603090070\",\"title\":\"TheLeagueofExtraordinaryGentlemen(VolIII):Century#3-2009\"},{\"isbn\":\"9781603091527\",\"title\":\"TheLovelyHorribleStuff\"},{\"isbn\":\"9781603090742\",\"title\":\"TheUnderwaterWelder\"},{\"isbn\":\"9781603094504\",\"title\":\"TheyCalledUsEnemy\"},{\"isbn\":\"9781891830310\",\"title\":\"ThreeFingersbyRichKoslowski\"},{\"isbn\":\"9781891830983\",\"title\":\"TooCooltoBeForgotten\"},{\"isbn\":\"9781603090889\",\"title\":\"UpsideDown(Book1):AVampireTale\"},{\"isbn\":\"9781603093712\",\"title\":\"UpsideDown(Book2):AHatFullofSpells\"},{\"isbn\":\"9781891830723\",\"title\":\"WillYouStillLoveMeIfIWettheBedbyLizPrince\"},{\"isbn\":\"9781603094405\",\"title\":\"Ye\"}]";
    /*    assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/books",
                String.class)).contains(expectedJson);
*/

        mockMvc.perform
                (get("/api/books").contentType(MediaType.APPLICATION_JSON)
                .with(org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic("admin", "admin")))                /*.andExpect(MockMvcResultMatchers.jsonPath("$.resultCode", is("SUCCESS")))*/
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].isbn").value("9781603094450"));

        /*ResponseEntity<String> response = template.getForEntity("/", String.class);
        assertThat(response.getBody()).isEqualTo("Greetings from Spring Boot!");
*/
                //.andExpect((ResultMatcher) MockMvcResultMatchers.jsonPath(expectedJson));
                //.andExpect(MockMvcResultMatchers.content().json(expectedJson));
                /*.andExpect(jsonPath("$[0].isbn").value("9781603094450")),*/


                /*.content(objectMapper.writeValueAsString(expectedJson)))
                .andExpect(content().string(equalTo(expectedJson)));*/

                //.andExpect(status().isOk())

    }

    @Test
    public void postBook() throws Exception {
        String requestBody = "{\"isbn\": \"123456\", \"title\": \"my book test\"}";

        mockMvc.perform(MockMvcRequestBuilders.post("/api/books")
                        .with(SecurityMockMvcRequestPostProcessors.httpBasic("admin","admin"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                /*.andExpect(MockMvcResultMatchers.status().isOk())*/
                .andExpect(MockMvcResultMatchers.status().is(201))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));


    }



}