package com.cicd;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class App {

    public static double calculateTotal(double price, int quantity) {
        return price * quantity;
    }

    public static void main(String[] args) throws IOException {

        HttpServer server = HttpServer.create(
                new InetSocketAddress(8080),
                0
        );

        server.createContext("/", App::handleRequest);

        server.setExecutor(null);

        System.out.println("Application started on port 8080");

        server.start();
    }

    private static void handleRequest(HttpExchange exchange) throws IOException {

        String response =
                "<html>" +
                "<head><title>CICD Java Application</title></head>" +
                "<body>" +
                "<h1>CICD Java Application</h1>" +
                "<h2>Application deployed through CI/CD pipeline!</h2>" +
                "<p>Price: 100.0</p>" +
                "<p>Quantity: 3</p>" +
                "<p>Total: 300.0</p>" +
                "</body>" +
                "</html>";

        exchange.getResponseHeaders()
                .set("Content-Type", "text/html");

        exchange.sendResponseHeaders(
                200,
                response.getBytes().length
        );

        try (OutputStream outputStream = exchange.getResponseBody()) {
            outputStream.write(response.getBytes());
        }
    }
}