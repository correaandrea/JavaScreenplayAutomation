#Author: Andre
#Language: es

Feature: Inicio de sesión de usuario
  Como usuario registrado,
  quiero poder iniciar sesión con mis credenciales válidas,
  para acceder a las funcionalidades de la plataforma.

  Scenario: Inicio de sesión exitoso con credenciales válidas
    Given que me encuentro en la página de inicio
    When hago clic en el botón de iniciar sesión
    And ingreso el correo electrónico "sofia.torres@udea.edu.co" y la contraseña "segura123"
    Then deberia ser redirigido al home y ver mi sesion iniciada con el nombre "Sofia"

  Scenario: Inicio de sesión fallido con credenciales inválidas
    Given que me encuentro en la página de inicio
    When hago clic en el botón de iniciar sesión
    And ingreso el correo electrónico "usuario.incorrecto@test.com" y la contraseña "clave-mala"
    Then debería permanecer en la página de inicio de sesión

