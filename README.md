# InnovaPatikaSpringBootcampBitirmeProjesi
InnovaPatikaSpringBootcampBitirmeProjesi

[Front-end Kısmı için tıklayınız](https://github.com/ozanaydogan/frontendInnovaPatikaSpringBootcampBitirmeProjesi/tree/main/react-frontend)

```diff
!## Proje hakkında detaylı bilgiler için pdf dosyasını inceleyebilirsiniz@@

[Proje hakkında detaylı bilgilendirme için PDF dosyası](https://github.com/ozanaydogan/InnovaPatikaSpringBootcampBitirmeProjesi/blob/main/%C4%B0nnova-Patika%20Spring%20Bootcamp%20Bitirme%20Projesi%20Kimlik%20numaras%C4%B1yla%20kredi%20sorgulama.pdf
)

# Projenin amacı

Kullanıcıdan alınan Kullanıcı adı, soyadı, email adresi, maaş bilgisi, kimlik numarası, telefon numarası bilgileriyle, sisteme kayıt olabilir, kaydını silebilir, kaydını güncelleyebilir ve Kredi limit bilgisini sorgulayabilir.

# Kullanılan teknolojiler
Spring <br/>
ReactJS <br/>
MySql <br/>

# Api istekleri için

GET /api/v1/users/citizenshipNumber/{citizenshipNumber} kimlik numarasına göre veritabanından kullanıcıyı getirme <br/>
GET /api/v1/users/citizenshipNumber/creditscore/{citizenshipNumber} kimlik numarasına göre kredli limiti sorgulama <br/>

GET /api/v1/users tüm kullanıcıları listelemek için <br/>
GET /api/v1/users/{id} id'ye göre kullanıcıyı getirmek için <br/>
POST /api/v1/users gelen verinin veritabanına kaydetmek için <br/>
PUT /api/v1/users/{id} id'ye göre kullanıcıyı update etmek için <br/> 
DELETE /api/v1/users/{id} id'ye göre kullanıcıyı silmek için <br/>

# Swagger
 
çalıştırdığınız porta göre değişebilir. <br/>
http://localhost:8081/swagger-ui/index.html#/ <br/>

![swagger](https://user-images.githubusercontent.com/49997690/155903067-4e8f9324-a7a0-4bdb-bed5-ae3a9724f9f1.PNG)
<br/>
# Projenin Yapısı

![gorsel](https://user-images.githubusercontent.com/49997690/155903108-868d22ba-aa9d-407b-a422-e19661de9244.png)
<br/>
# MySql

localhost:3306 <br/>
tablo adı : user_management_system <br/>




