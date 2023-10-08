package projetoHibridoDeAutonacaoPB.api.data;

import java.util.HashMap;
import java.util.Map;

public class Usuario {
    public String getString() {
        return "{\n" +
                "  \"name\": \"Fabiano dias\",\n" +
                "  \"username\": \"Andrade\",\n" +
                "  \"email\": \"fda@gmail.com\",\n" +
                "  \"address\": {\n" +
                "    \"street\": \"barueri sp\",\n" +
                "    \"suite\": \"Apt. 123\",\n" +
                "    \"city\": \"barueri\",\n" +
                "    \"zipcode\": \"98888-889\",\n" +
                "    \"geo\": {\n" +
                "      \"lat\": \"-37.3159\",\n" +
                "      \"lng\": \"81.1496\"\n" +
                "    }\n" +
                "  },\n" +
                "  \"phone\": \"+55(11)966669999\",\n" +
                "  \"website\": \"hildegard.org\",\n" +
                "  \"company\": {\n" +
                "    \"name\": \"Romaguera-Crona\",\n" +
                "    \"catchPhrase\": \"Multi-layered client-server\",\n" +
                "    \"bs\": \"real-time e-markets\"\n" +
                "  }\n" +
                "}";
    }

    public Map<String, String> putString() {
        Map<String, String> usuario = new HashMap<>();
        usuario.put("name", "teste de alteracao");
        usuario.put("username", "put test");
        usuario.put("email", "123mudar@gmail.com");

        return usuario;
    }
}
