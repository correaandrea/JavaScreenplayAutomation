#Author: Andre
  #Language: es

Feature: Autenticación de usuario
  Como usuario de la aplicación ViveMedellín
  Necesito poder interactuar con el formulario de inicio de sesión
  Para poder intentar acceder a contenido protegido (cuando se implemente un backend)

  Scenario: Inicio de sesión simulado exitoso
    Given que estoy en la página de inicio de sesión
    When ingreso mis credenciales "test@example.com" y "password123" y doy click al boton iniciar sesion y doy click al boton de regreso
    Then debo poder ver el icono de usuario en la pantalla