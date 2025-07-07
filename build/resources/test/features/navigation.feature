#Author: Andre
#Language: es

Feature: Navegación entre secciones del sitio

  Scenario: Un usuario navega entre las secciones desde la página de inicio
    Given que ingreso desde el home
    When hago clic en la sección "Eventos y Actividades"
    And luego hago clic en la sección "Comunidades"
    And finalmente hago clic en la sección "Valoraciones"
    Then debo estar en la sección "Valoraciones"

  Scenario: Navegación del login al registro
    Given que me encuentro en la página de inicio
    When hago clic en el botón de iniciar sesión
    And hago clic en el enlace de registro
    Then debería estar en la página de registro

  Scenario: Navegación del registro al login
    Given que me encuentro en la página de inicio
    When navego a la pagina de registro
    And hago clic en el enlace de iniciar sesión
    Then debería estar en la página de inicio de sesión
