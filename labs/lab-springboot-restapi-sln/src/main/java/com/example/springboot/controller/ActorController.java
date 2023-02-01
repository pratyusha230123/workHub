package com.example.springboot.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sprinboot.model.Actor;
import com.example.sprinboot.service.ActorService;

import java.util.Map;

@RestController
@RequestMapping("api/v1/actors")
public class ActorController {

	private final ActorService service;

    @Autowired
    public ActorController(ActorService service) {
        this.service = service;
    }

    @GetMapping()
    public String getActorDetails() {
        // DISPLAY ACTOR NAME & ACTOR MOVIE AS A TABLE WITH CSS STYLING

        Map<Integer, Actor> actors = service.getActors();

        String htmlOutputString = "<!DOCTYPE html>" +
                "<html lang=\"en\">\n" +
                "<head>" +
                "  <title>Bootstrap Example</title>\n" +
                "  <meta charset=\"utf-8\">\n" +
                "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "  <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\n" +
                "  <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js\"></script>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "<div class=\"container mt-3\">" +
                "  <h2>Actors list</h2>\n" +
                "  <table class=\"table table-striped\">\n" +
                "    <thead>\n" +
                "      <tr>\n" +
                "        <th>Firstname</th>\n" +
                "        <th>Lastname</th>\n" +
                "        <th>LastUpdate</th>\n" +
                "      </tr>\n" +
                "    </thead>\n" +
                "    <tbody>\n" +
                "      <tr>";
        for(Actor a : actors.values()){
            htmlOutputString +="<tr>"+
                                "<td>" + a.getFirstName()+"</td>" +
                                "<td>" + a.getLastName() +"</td>" +
                                "<td>" + a.getLastUpdate() +"</td></tr>";
        }
            htmlOutputString +="</tbody></table></div></body></html>";

       /* String htmlOutputString = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "  <title>Bootstrap Example</title>\n" +
                "  <meta charset=\"utf-8\">\n" +
                "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "  <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\n" +
                "  <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js\"></script>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "<div class=\"container mt-3\">\n" +
                "  <h2>Actors</h2>\n" +
                "  <table class=\"table table-striped\">\n" +
                "    <thead>\n" +
                "      <tr>\n" +
                "        <th>Firstname</th>\n" +
                "        <th>Lastname</th>\n" +
                "        <th>Email</th>\n" +
                "      </tr>\n" +
                "    </thead>\n" +
                "    <tbody>\n" +
                "      <tr>\n" +
                "        <td>John</td>\n" +
                "        <td>Doe</td>\n" +
                "        <td>john@example.com</td>\n" +
                "      </tr>\n" +
                "      <tr>\n" +
                "        <td>Mary</td>\n" +
                "        <td>Moe</td>\n" +
                "        <td>mary@example.com</td>\n" +
                "      </tr>\n" +
                "      <tr>\n" +
                "        <td>July</td>\n" +
                "        <td>Dooley</td>\n" +
                "        <td>july@example.com</td>\n" +
                "      </tr>\n" +
                "    </tbody>\n" +
                "  </table>\n" +
                "</div>\n" +
                "\n" +
                "</body>\n" +
                "</html>";*/

        return htmlOutputString;
    }
}