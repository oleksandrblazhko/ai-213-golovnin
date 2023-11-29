|FR id|TC id|Опис кроків тестового сценарію|Опис очікуваних результатів|
|:-----:|:-----:|:-----|:-----:|
|FR1.1|TC 1.1|Початкові умови: користувач має бути авторизований<br> Кроки сценарію:<br> user = "Artem"<br> password = "********"<br> location = "Odessa"|Результат:<br>airClear= Your town in general has excellent air quality.The level of air pollution at the moment meets all norms and safety standards. You can enjoy fresh air and safe living conditions. <br> Air Clear = 80 %<br>result=1|
|FR1.1|TC 1.2|Початкові умови: користувач має бути авторизований<br> Кроки сценарію:<br> user = ""<br> password = "********"<br> location = "Odessa"|result=-1|
|FR1.1|TC 1.3|Початкові умови: користувач має бути авторизований<br> Кроки сценарію:<br> user = "Artem"<br> password = "***"<br> location = "Odessa"|result=-1|
|FR1.1|TC 1.4|Початкові умови: користувач має бути авторизований<br> Кроки сценарію:<br> user = "Artem"<br> password = "**************************************"<br> location = "Odessa"|result=-1|
|FR1.1|TC 1.5|Початкові умови: користувач має бути авторизований<br> Кроки сценарію:<br> user = "Artem"<br> password = "********"<br> location = "Odessa......"|result=-1|
