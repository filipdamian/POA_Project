# POA_Project
TEMA : o aplicatie de gestionare a unei clinici unde sunt inregistrati doctori de diferite tipuri ( medic de familie, specialist (orl, alergolog, etc) si medic chirurg),
pacienti care detin carduri de sanatate si un istoric al afectiunilor. Pacientii pe baza cardului de sanatate pot beneficia de programari gratuite sau contra cost in caz
contrar.

Etapa 1 

Structura proiect:

  DOMAIN
      Pacient (+Pacient Factory)
      Doctor  (+Doctor Factory)
         - de familie
         - specialist
         - chirurg
      Programare
      Card Sanatate
      Istoric
      
  PERSISTENCE
      CardSanatateRepository (implemets GenericRepository)
      DoctorRepository (implemets GenericRepository)
      IstoricRepository (implemets GenericRepository)
      PacientRepository (implemets GenericRepository)
      ProgramareRepository (implemets GenericRepository)
      
  SERVICE
      CardSanatateService 
      DoctorService 
      PacientService
      IstoricService
      ProgramareService
 
  VIEW
      ConsoleApp
      
Obiecte create:
      Pacient (PacientFactory),Doctor(Doctor Factory) de familie, Doctor Specialist, Medic Chirurg, Programare, Card Sanatate, Istoric, CardSanateRepo, IstoricRepo,
  PacientRepo, DoctorRepo, ProgramareRepo, CardSanatateService, IstoricService, DoctorService, PacientService, ProgramareService


Interogari:
      inregistreaza un pacient
      cauta pacient dupa nume
      modifica cnp pacient
      sterge pacient dupa cnp
      inregistreaza un doctor
      cauta doctor dupa nume
      adauga numar de operatii la un medic chirurg
      modifca numarul de pacienti inscrisi la un doctor
      setare intreare in concediu pentru un doctor
      adaugare istoric unui pacient
      cautare istoric pacient
      inregistrare card nou de sanatate 
      afisare toate cardurile de sanatate
      creaza o noua programare
      afiseaza toata programarile
      
      
 
      
  
  
