import { toggleDarkTheme } from "./themeSwitcher.js";

let themeButton = document.getElementById("theme-button");
let themeLogo = document.getElementById("theme-logo");

let theme = "light";

themeButton.addEventListener("click", () => {
  if (theme === "light") {
    theme = "dark";
    themeLogo.name = "sunny";
  } else if (theme === "dark") {
    theme = "light";
    themeLogo.name = "moon";
  }

  toggleDarkTheme(theme);
});