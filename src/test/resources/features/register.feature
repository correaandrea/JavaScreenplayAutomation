#Author: Andre
#Language: es

Feature: Funcionalidad de Registro de Usuario
  Como un nuevo visitante de la plataforma,
  quiero poder registrar una cuenta
  para acceder a las funcionalidades personalizadas.

  Scenario: Registro exitoso de un nuevo usuario
    Given que me encuentro en la página de inicio
    When navego a la pagina de registro
    And me registro con los datos: "Andrea", "Correa", "andrea.correa@udea.edu.co", "segura123" y "segura123"
    Then deberia ser redirigido al home y ver mi sesion iniciada con el nombre "Andrea"

