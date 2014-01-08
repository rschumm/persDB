package ch.saxer.persDB;

import static com.eclipsesource.restfuse.Assert.assertOk;
import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.runner.RunWith;

import com.eclipsesource.restfuse.Destination;
import com.eclipsesource.restfuse.HttpJUnitRunner;
import com.eclipsesource.restfuse.Method;
import com.eclipsesource.restfuse.Response;
import com.eclipsesource.restfuse.annotation.Context;
import com.eclipsesource.restfuse.annotation.HttpTest;

@RunWith(HttpJUnitRunner.class)
public class RestServerTest {

    @Rule
    private Destination destination = new Destination(this, "http://localhost:8080");

    @Context
    private Response response; // will be injected after every request

    @HttpTest(method = Method.GET, path = "persDB/rest/r/adressen")
    public void checkRestfgetAdressen() {
        String erwAntwort = "[{\"id\":1,\"personen\":null,\"plz\":\"80576-823\",\"ort\":\"Montbliart\"},{\"id\":2,\"personen\":null,\"plz\":\"3930\",\"ort\":\"Warren\"},{\"id\":3,\"personen\":null,\"plz\":\"V9B 5M0\",\"ort\":\"Stirling\"},{\"id\":4,\"personen\":null,\"plz\":\"3659\",\"ort\":\"Darlington\"},{\"id\":5,\"personen\":null,\"plz\":\"54679\",\"ort\":\"Cape Breton Island\"},{\"id\":6,\"personen\":null,\"plz\":\"22647-111\",\"ort\":\"Haguenau\"},{\"id\":7,\"personen\":null,\"plz\":\"6679LY\",\"ort\":\"Columbia\"},{\"id\":8,\"personen\":null,\"plz\":\"R1M 7R0\",\"ort\":\"Los Angeles\"},{\"id\":9,\"personen\":null,\"plz\":\"9729NW\",\"ort\":\"Baie-Comeau\"},{\"id\":10,\"personen\":null,\"plz\":\"67485\",\"ort\":\"Tuscaloosa\"},{\"id\":11,\"personen\":null,\"plz\":\"95784\",\"ort\":\"Chesterfield\"},{\"id\":12,\"personen\":null,\"plz\":\"0062\",\"ort\":\"Huntsville\"},{\"id\":13,\"personen\":null,\"plz\":\"21312\",\"ort\":\"South Bend\"},{\"id\":14,\"personen\":null,\"plz\":\"0129\",\"ort\":\"Guirsch\"},{\"id\":15,\"personen\":null,\"plz\":\"1327\",\"ort\":\"Pugwash\"},{\"id\":16,\"personen\":null,\"plz\":\"2214\",\"ort\":\"Champorcher\"},{\"id\":17,\"personen\":null,\"plz\":\"9109AL\",\"ort\":\"Preore\"},{\"id\":18,\"personen\":null,\"plz\":\"8395\",\"ort\":\"Carunchio\"},{\"id\":19,\"personen\":null,\"plz\":\"1290\",\"ort\":\"Monstreux\"},{\"id\":20,\"personen\":null,\"plz\":\"7456FP\",\"ort\":\"Pagazzano\"},{\"id\":21,\"personen\":null,\"plz\":\"5408\",\"ort\":\"Hard\"},{\"id\":22,\"personen\":null,\"plz\":\"21757\",\"ort\":\"Squillace\"},{\"id\":23,\"personen\":null,\"plz\":\"38663\",\"ort\":\"Spiere-Helkijn\"},{\"id\":24,\"personen\":null,\"plz\":\"71012\",\"ort\":\"Abergele\"},{\"id\":25,\"personen\":null,\"plz\":\"2400\",\"ort\":\"Rocca di Cambio\"},{\"id\":26,\"personen\":null,\"plz\":\"45284\",\"ort\":\"Penzance\"},{\"id\":27,\"personen\":null,\"plz\":\"6204\",\"ort\":\"Caucaia\"},{\"id\":28,\"personen\":null,\"plz\":\"08375\",\"ort\":\"San Mauro Marchesato\"},{\"id\":29,\"personen\":null,\"plz\":\"7019\",\"ort\":\"Milmort\"},{\"id\":30,\"personen\":null,\"plz\":\"6680\",\"ort\":\"St. David\"}]";

        assertOk(response);
        String body = response.getBody();
        assertEquals(erwAntwort, body);

    }

    // @HttpTest(method = Method.GET, path = "persDB/rest/r/person/Minerva/POTTER")
    // public void checkRestfgetPerson() {
    // String erwAntwort =
    // "[]";
    //
    // assertOk(response);
    // String body = response.getBody();
    // assertEquals(erwAntwort, body);
    //
    // }
}
