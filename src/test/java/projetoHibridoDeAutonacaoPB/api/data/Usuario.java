package projetoHibridoDeAutonacaoPB.api.data;

import java.util.HashMap;
import java.util.Map;

public class Usuario {
    public String getString() {
        return """{
                        "name": "Fabiano dias",
                        "username": "Andrade",
                        "email": "fda@gmail.com",
                        "address": {
                            "street": "barueri sp",
                            "suite": "Apt. 123",
                            "city": "barueri",
                            "zipcode": "92998-3874",
                            "geo": {
                                "company": {
                                    "name": "Romaguera-Crona",
                                    "catchPhrase": "Multi-layered client-server",
                                    "bs": "real-time e-markets"
                                }
                            }
                        }
                    }""";

    }

    public Map<String, String> putString() {
        Map<String, String> usuario = new HashMap<>();
        usuario.put("name", "teste de alteracao");
        usuario.put("username", "put test");
        usuario.put("email", "123mudar@gmail.com");

        return usuario;
    }
}
