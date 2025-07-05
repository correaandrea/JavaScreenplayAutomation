#Author: Andre
#Language: es

Feature: Inicio de sesión de usuario

  Scenario: Inicio de sesión exitoso con credenciales válidas
    Given que me encuentro en la página de inicio
    When hago clic en el botón de iniciar sesión
    And ingreso el correo electrónico "kieroyorar3@correo.com" y la contraseña "guacala"
    And hago clic en el botón de iniciar sesión para confirmar
    Then debo ser redirigido a la página de inicio con mi sesión iniciada