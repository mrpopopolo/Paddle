const root = document.documentElement;

const getBlackColors = () => {
  const bleuopt =
    getComputedStyle(root).getPropertyValue("--bleuopt");
  const grisopt =
    getComputedStyle(root).getPropertyValue("--grisopt");
  const rougeopt =
    getComputedStyle(root).getPropertyValue("--rougeopt");

  return [bleuopt, grisopt, rougeopt];
};

const getWhiteColors = () => {
  const bleubase =
    getComputedStyle(root).getPropertyValue("--bleubase");
  const grisbase =
    getComputedStyle(root).getPropertyValue("--grisbase");
  const rougebase =
    getComputedStyle(root).getPropertyValue("--rougebase");

  return [bleubase, grisbase, rougebase];
};

export const toggleDarkTheme = (theme) => {
  const [bleuopt, grisopt, rougeopt] = getBlackColors();
  const [bleubase, grisbase, rougebase] = getWhiteColors();

  if (theme && theme === "light") {
    root.style.setProperty("--bleut", bleubase);
    root.style.setProperty("--gris", grisbase);
    root.style.setProperty("--rouge", rougebase);
  } else if (theme && theme === "dark") {
    root.style.setProperty("--bleu", bleuopt);
    root.style.setProperty("--gris", grisopt);
    root.style.setProperty("--rouge", rougeopt);
  } else {
    return;
  }
};
