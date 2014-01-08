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
    public Destination destination = new Destination(this, "http://localhost:8080");

    @Context
    private Response response; // will be injected after every request

    @HttpTest(method = Method.GET, path = "persDB/rest/r/adressen")
    public void checkRestfgetAdressen() {
        String erwAntwort = "[{\"id\":1,\"plz\":\"80576-823\",\"ort\":\"Montbliart\"},{\"id\":2,\"plz\":\"3930\",\"ort\":\"Warren\"},{\"id\":3,\"plz\":\"V9B 5M0\",\"ort\":\"Stirling\"},{\"id\":4,\"plz\":\"3659\",\"ort\":\"Darlington\"},{\"id\":5,\"plz\":\"54679\",\"ort\":\"Cape Breton Island\"},{\"id\":6,\"plz\":\"22647-111\",\"ort\":\"Haguenau\"},{\"id\":7,\"plz\":\"6679LY\",\"ort\":\"Columbia\"},{\"id\":8,\"plz\":\"R1M 7R0\",\"ort\":\"Los Angeles\"},{\"id\":9,\"plz\":\"9729NW\",\"ort\":\"Baie-Comeau\"},{\"id\":10,\"plz\":\"67485\",\"ort\":\"Tuscaloosa\"},{\"id\":11,\"plz\":\"95784\",\"ort\":\"Chesterfield\"},{\"id\":12,\"plz\":\"0062\",\"ort\":\"Huntsville\"},{\"id\":13,\"plz\":\"21312\",\"ort\":\"South Bend\"},{\"id\":14,\"plz\":\"0129\",\"ort\":\"Guirsch\"},{\"id\":15,\"plz\":\"1327\",\"ort\":\"Pugwash\"},{\"id\":16,\"plz\":\"2214\",\"ort\":\"Champorcher\"},{\"id\":17,\"plz\":\"9109AL\",\"ort\":\"Preore\"},{\"id\":18,\"plz\":\"8395\",\"ort\":\"Carunchio\"},{\"id\":19,\"plz\":\"1290\",\"ort\":\"Monstreux\"},{\"id\":20,\"plz\":\"7456FP\",\"ort\":\"Pagazzano\"},{\"id\":21,\"plz\":\"5408\",\"ort\":\"Hard\"},{\"id\":22,\"plz\":\"21757\",\"ort\":\"Squillace\"},{\"id\":23,\"plz\":\"38663\",\"ort\":\"Spiere-Helkijn\"},{\"id\":24,\"plz\":\"71012\",\"ort\":\"Abergele\"},{\"id\":25,\"plz\":\"2400\",\"ort\":\"Rocca di Cambio\"},{\"id\":26,\"plz\":\"45284\",\"ort\":\"Penzance\"},{\"id\":27,\"plz\":\"6204\",\"ort\":\"Caucaia\"},{\"id\":28,\"plz\":\"08375\",\"ort\":\"San Mauro Marchesato\"},{\"id\":29,\"plz\":\"7019\",\"ort\":\"Milmort\"},{\"id\":30,\"plz\":\"6680\",\"ort\":\"St. David\"}]";

        assertOk(response);
        String body = response.getBody();
        assertEquals(erwAntwort, body);

    }

    @HttpTest(method = Method.GET, path = "persDB/rest/r/person/Minerva/Potter")
    public void checkRestfgetPerson() {
        String erwAntwort = "{\"name\":\"Potter\",\"vorname\":\"Minerva\",\"email\":\"Integer@acmieleifend.org\",\"id\":51,\"adresse\":{\"id\":14,\"plz\":\"0129\",\"ort\":\"Guirsch\"},\"items\":[{\"id\":58,\"nr\":\"0506594021\"}]}";
        assertOk(response);
        String body = response.getBody();
        assertEquals(erwAntwort, body);

    }

    /*
     * TODO does not work
     */
    @HttpTest(method = Method.POST, path = "persDB/rest/r/addItem", content = "{\"id\":333,\"nr\":\"333\"}")
    public void addItem() {
        System.out.println(response.getBody() + " " + response.getStatus());

    }

    /*
     * TODO does not work
     */
    @HttpTest(method = Method.DELETE, path = "persDB/rest/r/deleteItem/1")
    public void deleteItem() {
        System.out.println(response.getBody() + " " + response.getStatus());
    }
}
