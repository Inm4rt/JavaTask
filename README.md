# JavaTask
* Данное приложение обрабатывает GET, POST, PUT, DELETE запросы.
* Для просмотра всех записей в базе необходимо отправить GET запрос по адресу "/".
* Для просмотра одной записи в базе необходимо отправить GET запрос по адресу "/one?id=" после равно нужный id.
* Для добавления необходимо отправить POST запрос по адресу "/" в теле которого будет находится JSON следующего вида:
```JSON
{
    "firstName": "Alexey",
    "lastName": "Nikolaev",
    "age": 21,
    "mark": 99.9,
    "education": true,
    "category": "b"
}
```
* Для обновления необходимо отправить PUT запрос по адресу "/update?id=", где после равно поставить необходимый id. В теле JSON следующего вида:
```JSON
{
    "firstName": "Alexey",
    "lastName": "Nikolaev",
    "age": 21,
    "mark": 99.9,
    "education": true,
    "category": "b"
}
```
* Для обновления необходимо отправить DELETE запрос по адресу "/delete?id=", где после равно поставить необходимый id.
