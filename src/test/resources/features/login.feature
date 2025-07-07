#Author: Andre
#Language: es

Feature: Inicio de sesión de usuario

  Scenario: Inicio de sesión exitoso con credenciales válidas
    Given que me encuentro en la página de inicio
    When hago clic en el botón de iniciar sesión
    And ingreso el correo electrónico "sofia.torres@udea.edu.co" y la contraseña "segura123"
    And hago clic en el botón de iniciar sesión para confirmar
    Then deberia ser redirigido al home y ver mi sesion iniciada con el nombre "Sofia"