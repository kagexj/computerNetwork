# computerNetwork
<p><b>1. Разработка элементарных приложений на языке Java.</b></p>

Разработать класс, решающий квадратные уравнения. Коэффициенты квадратного трехчлена или передаются в качестве параметров класса, в противном случае вводятся из консоли. Коэффициенты могут быть любыми действительными числами.

Требования к решению:
1. В решении должен присутствовать класс "Квадратное уравнение"
В этом классе должны присутствовать два конструктора: первый с тремя параметрами, а второй с одним параметром - сканнером. В первом случае передаются коэффициенты уравнения и сохраняются в классе. Во втором случае коэффициенты нужно читать из полученного сканера. Допустимо во второй конструктор передавать сканер, из которого будут читаться коэффициенты.
2. Решение должно корректно обрабатывать случаи равенства нулю некоторых из коэффициентов уравнения, в частности a=0.

<p><b>2. Разработка многопоточных приложений на языке Java.</b></p>

1. Разработать многопоточное приложение, позволяющее в интервале 100000000 — 400000000 найти все числа, которые одновременно делятся на 11, 13, 17 и 19. Выяснить различие во времени выполнения программы для случая одного потока и трех потоков. (60 баллов)
2. Предусмотрите возможность указать количество создаваемых потоков при запуске приложения (40 баллов)

<p><b>3. Разработка многопоточных приложений на языке Java. Синхронизация потоков. </b></p>

Разработать приложение, решающее задачу о синхронизации производитель-потребитель. Дано два потока, один из потоков должен передать другому последовательность целых чисел длины n, например, квадратов натуральных чисел. Другой поток должен принять и распечатать эту последовательность.

Решить задачу двумя способами:

1. С использованием класса BlockingQueue (60 баллов)
2. С использованием общих переменных и методов wait/notify (40 баллов)

<p><b>4. Разработка клиент-серверных приложений на языке Java. </b></p>

Задание 1. Разработать сервер позволяющий сохранять пары ключ-значение. Клиенты могут просить сервер выполнить два типа запросов. В ответ на запрос "put ключ значение", сервер должен запомнить, что в ключу соответствует сообщение с текстом "значение". В ответ на запрос "get ключ" сохранённое значение должно отправляться клиенту. Рекомендуется использовать HashMap и BufferedReader. Для проверки использовать консольную программу telnet (при запуске указывайте 2 параметра: адрес и порт). (60 баллов)

Задание 2. Реализовать задание "Разработка многопоточных приложений на языке Java" в клиент-серверном варианте, т.е. сервер запускается и ожидает подключения клиента(тов), клиент, подключившись к серверу, получает от него порядковый номер и интервал длинною в 100000000 и возвращает серверу найденные числа. Предусмотреть вывод консольных сообщений на стороне сервера.

Этапы выполнения задания:

1. Сервер ожидает подключения трёх клиентов. После подключения всех клиентов, каждому из них выдаётся порядковый номер и интервал. В консоль выводится, какой интервал каждому из них был выдан. После этого сервер ожидает от клиента результата и выводит найденные числа в консоль. Клиенты отключаются после отправки результата решенной задачи. (20 баллов)
2. Сервер ожидает подключения трёх клиентов, но данные для обработки отправляются сразу же после подключения, а результат получается по мере готовности. Для этого необходимо создать на сервере для каждого подключенного клиента отдельный поток, который бы занимался передачей и приемом сообщений. Клиенты отключаются после отправки результата решенной задачи. (20 баллов)
3. Сервер ожидает подключения неограниченного количества клиентов. Клиенты не прекращают работу после решения одной задачи, а ожидают от сервера дополнительных задач. Необходимо предусмотреть возможность добавления задач на сервере через консоль в формате L R Step (найти количество чисел в отрезке [L,R], которые делятся на 11, 13, 17 и 19, разделив этот отрезок на куски длиной Step. Последний кусок может иметь меньшую длину). (1 бонусный балл)

<p><b>5. Разработка сервлетов на языке Java. </b></p>

Разработать сервлет, позволяющий получать от пользователя задачи, раздавать клиентам-рабочим задания, собирать его и отправлять полученный результат пользователю.

Этапы выполнения задания:

1. Приложение должно включать в себя java сервлет и jsp страницу. На странице находится форма, в которой можно задать диапазон для поиска чисел, которые делятся на 11, 13 и 17. Результат работы формы отправляется на ту же страницу. Сервлет или просто перенаправляет вывод на jsp страницу, если запроса не было, или выводит все найденные числа под формой. (60 баллов)
2. Сервлет отправляет поступающие к нему запросы приложению Сервер из задания "Клиент-серверные приложения". Результаты работы сервера выводятся на страницу по мере готовности. (Примечание: Сервер можно добавить в состав проекта с сервлетом, а можно подключаться к нему по сети) (+20 баллов) .
3. Дополните ваше приложение, выполнив следующие задачи:
Подключать в JSP страницах заголовок из отдельного файла (+5 баллов)
Добавить отдельную JSP страницу для вывода ответов на запросы (+5 баллов)
Добавить страницу, на которой можно посмотреть информацию о всех подключенных к серверу клиентах-рабочих с возможностью их отключения (+5 баллов)
Добавить работу с сессиями (запоминать предыдущий запрос в сессии пользователя, чтобы при следующих обращениях к странице подставлялся именно он / показывать только те запросы, которые сделал сам пользователь)  (+5 баллов)




<h1><p><b>Индивидуальное задание</b></p></h1>

Список заданий
1. Задана сеть, состоящая из n сегментов и n-1 концентратора. Для каждого сегмента задан его тип и длина. Произвести оценку конфигурации сети  по физическим ограничениям: на длину сегмента, на длину сети, правило «4 хаба» («5 хабов» для 10Base-FB), по времени двойного оборота сигнала в сети, по уменьшению межкадрового интервала. По результатам расчетов сделать вывод о корректности конфигурации сети Ethernet и  оформить отчёт.
2. Задана схема сети и диапазон возможных адресов. Назначить IP-адреса и задать статическую маршрутизацию для каждой подсети.
