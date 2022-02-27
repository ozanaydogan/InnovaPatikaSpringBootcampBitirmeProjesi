# InnovaPatikaSpringBootcampBitirmeProjesi
InnovaPatikaSpringBootcampBitirmeProjesi

[Front-end Kısmı için tıklayınız](https://github.com/ozanaydogan/frontendInnovaPatikaSpringBootcampBitirmeProjesi/tree/main/react-frontend)

# Projenin amacı

Kullanıcıdan alınan Kullanıcı adı, soyadı, email adresi, maaş bilgisi, kimlik numarası, telefon numarası bilgileriyle, sisteme kayıt olabilir, kaydını silebilir, kaydını güncelleyebilir ve Kredi limit bilgisini sorgulayabilir.

# Kullanılan teknolojiler
Spring
ReactJS
MySql

# Api istekleri için

GET /api/v1/users/citizenshipNumber/{citizenshipNumber} kimlik numarasına göre veritabanından kullanıcıyı getirme
GET /api/v1/users/citizenshipNumber/creditscore/{citizenshipNumber} kimlik numarasına göre kredli limiti sorgulama

GET /api/v1/users tüm kullanıcıları listelemek için
GET /api/v1/users/{id} id'ye göre kullanıcıyı getirmek için
POST /api/v1/users gelen verinin veritabanına kaydetmek için
PUT /api/v1/users/{id} id'ye göre kullanıcıyı update etmek için
DELETE /api/v1/users/{id} id'ye göre kullanıcıyı silmek için

#Swagger

çalıştırdığınız porta göre değişebilir.
http://localhost:8081/swagger-ui/index.html#/


