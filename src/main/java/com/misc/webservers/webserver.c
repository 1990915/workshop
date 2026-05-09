// simple_http_server.c
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <unistd.h>      // برای close()
#include <arpa/inet.h>   // برای socket, bind, listen, accept

int main() {
    int server_fd, client_fd;
    struct sockaddr_in address;
    int addrLen = sizeof(address);

    // 1. ساختن سوکت (IPv4, TCP)
    server_fd = socket(AF_INET, SOCK_STREAM, 0);
    if (server_fd == -1) {
        perror("socket failed");
        exit(EXIT_FAILURE);
    }

    // 2. تنظیم ساختار آدرس سرور
    address.sin_family = AF_INET;            // IPv4
    address.sin_addr.s_addr = INADDR_ANY;    // همه‌ی اینترفیس‌ها (127.0.0.1 و ...)
    address.sin_port = htons(8080);          // پورت 8080 (تبدیل به network byte order)

    // 3. bind کردن سوکت به آدرس و پورت
    if (bind(server_fd, (struct sockaddr *)&address, sizeof(address)) < 0) {
        perror("bind failed");
        close(server_fd);
        exit(EXIT_FAILURE);
    }

    // 4. گوش دادن روی سوکت (حداکثر 10 کانکشن در صف)
    if (listen(server_fd, 10) < 0) {
        perror("listen failed");
        close(server_fd);
        exit(EXIT_FAILURE);
    }

    printf("Server is running on http://localhost:8080\n");

    while (1) {
        // 5. قبول کردن اتصال از یک کلاینت
        client_fd = accept(server_fd, (struct sockaddr *)&address, (socklen_t *)&addrLen);
        if (client_fd < 0) {
            perror("accept failed");
            continue; // به جای exit، ادامه می‌دهیم
        }

        // 6. خواندن درخواست (اما این‌جا فقط نادیده می‌گیریم)
        char buffer[1024] = {0};
        read(client_fd, buffer, sizeof(buffer) - 1);
        printf("Request:\n%s\n", buffer);

        // 7. ساخت پاسخ HTTP ساده
        const char *body = "<h1>Hello, World! from C web server</h1>";
        char response[2048];

        // هدر + بادی
        snprintf(response, sizeof(response),
                 "HTTP/1.1 200 OK\r\n"
                 "Content-Type: text/html; charset=utf-8\r\n"
                 "Content-Length: %zu\r\n"
                 "Connection: close\r\n"
                 "\r\n"
                 "%s",
                 strlen(body), body);

        // 8. ارسال پاسخ به مرورگر
        send(client_fd, response, strlen(response), 0);

        // 9. بستن اتصال با کلاینت
        close(client_fd);
    }

    // (عملا این‌جا نمی‌رسیم)
    close(server_fd);
    return 0;
}
