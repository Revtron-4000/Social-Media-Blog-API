package Controller;

import Model.Account;
import Model.Message;
import Service.AccountService;
import Service.MessageService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.javalin.Javalin;
import io.javalin.http.Context;

/**
 * TODO: You will need to write your own endpoints and handlers for your controller. The endpoints you will need can be
 * found in readme.md as well as the test cases. You should
 * refer to prior mini-project labs and lecture materials for guidance on how a controller may be built.
 */
public class SocialMediaController {
    private AccountService as;
    private MessageService ms;

    public SocialMediaController() {
        as = new AccountService();
        ms = new MessageService();
    }


    /**
     * In order for the test cases to work, you will need to write the endpoints in the startAPI() method, as the test
     * suite must receive a Javalin object from this method.
     * @return a Javalin app object which defines the behavior of the Javalin controller.
     */
    public Javalin startAPI() {
        Javalin app = Javalin.create();
        app.get("example-endpoint", this::exampleHandler);
        app.post("/register", this::postRegisterHandler);
        app.post("/login", this::postLoginHandler);
        app.post("/messages", this::postMessagesHandler);

        app.get("/messages", this::getAllMessagesHandler);
        app.get("/messages/{message_id}", this::getMessageHandler);
        app.get("/accounts/{account_id}/messages", this::getAccountMessages);

        app.delete("/messages/{message_id}", this::deleteMessageHandler);

        app.patch("/messages/{message_id}", this::patchMessageHandler);


        return app;
    }

    /**
     * This is an example handler for an example endpoint.
     * @param context The Javalin Context object manages information about both the HTTP request and response.
     */
    private void exampleHandler(Context context) {
        context.json("sample text");
    }

    private void postRegisterHandler(Context ctx) throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        Account acc = om.readValue(ctx.body(), Account.class);
        Account addedAccount = as.createAccount(acc.getUsername(), acc.getPassword());

        if (addedAccount != null) {
            ctx.json(om.writeValueAsString(addedAccount));
            ctx.status(200);
        } else {
            ctx.status(400);
        }
    }

    private void postLoginHandler(Context ctx) throws JsonProcessingException { 
        ObjectMapper om = new ObjectMapper();
        Account acc = om.readValue(ctx.body(), Account.class);

        Account existingAcc = as.login(acc);
        if (existingAcc != null) {
            ctx.json(existingAcc);
            ctx.status(200);
        } else {
            ctx.status(401);
        }
    }

    private void postMessagesHandler(Context ctx) throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        Message m = om.readValue(ctx.body(), Message.class);

        Message existingMessage = ms.postMessage(m);
        if (existingMessage != null) {
            ctx.json(existingMessage);
            ctx.status(200);
        } else {
            ctx.status(400);
        }
    }

    private void getAllMessagesHandler(Context ctx) {
        ctx.json(ms.getAllMessages());
        ctx.status(200);
    }

    private void getMessageHandler(Context ctx) throws NumberFormatException {
        String message_id_String = ctx.pathParam("message_id");
        int message_id = Integer.valueOf(message_id_String);
        
        Message existingMessage = ms.getMessageById(message_id);
        if (existingMessage != null) {
            ctx.json(existingMessage);
        }
        ctx.status(200);
    }

    private void deleteMessageHandler(Context ctx) throws NumberFormatException {
        int message_id = Integer.valueOf(ctx.pathParam("message_id"));
        Message deletedMessage = ms.deleteMessageById(message_id);

        if (deletedMessage != null) {
            ctx.json(deletedMessage);
        }
        ctx.status(200);
    }

    private void patchMessageHandler(Context ctx) throws JsonProcessingException, NumberFormatException {
        ObjectMapper om = new ObjectMapper();
        Message newMessage = om.readValue(ctx.body(), Message.class);
        
        String newMessageText = newMessage.getMessage_text();
        int message_id = Integer.valueOf(ctx.pathParam("message_id"));
        
        Message updatedMessage = ms.updateMessageById(message_id, newMessageText);

        if (updatedMessage != null) {
            ctx.json(updatedMessage);
            ctx.status(200);
        } else {
            ctx.status(400);
        }
    }

    private void getAccountMessages(Context ctx) throws NumberFormatException {
        int account_id = Integer.valueOf(ctx.pathParam("account_id"));
        ctx.json(ms.getAccountMessages(account_id));
        ctx.status(200);
    }
}