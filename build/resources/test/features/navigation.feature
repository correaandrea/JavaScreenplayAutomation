#Author: Andre
#Language: es

Feature: Navegación entre secciones del sitio

  Scenario: Un usuario navega entre las secciones desde la página de inicio
    Given que ingreso desde el home
    When hago clic en la sección "Eventos y Actividades"
    And luego hago clic en la sección "Comunidades"
    And finalmente hago clic en la sección "Valoraciones"
    Then debo estar en la sección "Valoraciones"
