#Author: Andre
#Language: es

Feature: Funcionalidad de Registro de Usuario
  Como un nuevo visitante de la plataforma,
  quiero poder registrar una cuenta
  para acceder a las funcionalidades personalizadas.

  Scenario: Registro exitoso de un nuevo usuario
    Given me encuentro en la pagina de inicio
    When navego a la pagina de registro
    And me registro con los datos: "Sofia", "Torres", "sofia.torres@udea.edu.co", "segura123" y "segura123"
    Then deberia ser redirigido al home y ver mi sesion iniciada con el nombre "Sofia"

