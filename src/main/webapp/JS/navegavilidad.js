const d = document;

export function navegar(secciones, detonador, seccionID) {
    const enlace = d.querySelector(detonador);
    const grupo = d.querySelectorAll(secciones);
    const objetivo = d.getElementById(seccionID);

    if (!enlace || !objetivo) {
        console.error("No se encontró el enlace o la sección objetivo.");
        return;
    }

    d.addEventListener("click", (e) => {
        if (e.target === enlace) {
            grupo.forEach((value) => {
                value.style.opacity = "0";
                value.style.transition = "opacity 1s ease-out";
                setTimeout(() => {
                    value.style.display = "none";
                }, 1000);
            });
            setTimeout(() => {
                objetivo.style.opacity = "1";
                objetivo.style.display = "grid";
            }, 1000);
        }
    });
}



export function normal() {
    console.log("hola mundo");
}
