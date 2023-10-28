package projetoHibridoDeAutonacaoPB.api.data;

import java.util.HashMap;
import java.util.Map;

public class Usuario {
    public String getString() {
        // return """
        //         {
        //                     "name": "Fabiano dias",
        //                     "username": "Andrade",
        //                     "email": "fda@gmail.com",
        //                     "address": {
        //                         "street": "barueri sp",
        //                         "suite": "Apt. 123",
        //                         "city": "barueri",
        //                         "zipcode": "92998-3874",
        //                         "geo": {
        //                             "company": {
        //                                 "name": "Romaguera-Crona",
        //                                 "catchPhrase": "Multi-layered client-server",
        //                                 "bs": "real-time e-markets"
        //                             }
        //                         }
        //                     }
        //                 """;

        return "{\n" +
                "  \"name\": \"Fabiano dias\",\n" +
                "  \"username\": \"Andrade\",\n" +
                "  \"email\": \"fda@gmail.com\",\n" +
                "  \"address\": {\n" +
                "    \"street\": \"barueri sp\",\n" +
                "    \"suite\": \"Apt. 123\",\n" +
                "    \"city\": \"barueri\",\n" +
                "    \"zipcode\": \"92998-3874\",\n" +
                "    \"geo\": {\n" +
                "      \"lat\": \"-37.3159\",\n" +
                "      \"lng\": \"81.1496\"\n" +
                "    }\n" +
                "  },\n" +
                "  \"phone\": \"1-770-736-8031 x56442\",\n" +
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
