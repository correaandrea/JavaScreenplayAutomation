#Author: Andre
  #Language: es

Feature: Autenticación de usuario
  Como usuario de la aplicación ViveMedellín
  Necesito poder interactuar con el formulario de inicio de sesión
  Para poder intentar acceder a contenido protegido (cuando se implemente un backend)

  Scenario: Inicio de sesión simulado exitoso
    Given que estoy en la página de inicio de sesión
    When ingreso "test@example.com" en el campo de correo electrónico
    And ingreso "password123" en el campo de contraseña
    And hago clic en el botón "Iniciar sesión"
    Then debería seguir en la página de inicio de sesión
    And no debería ver ningún mensaje de error explícito