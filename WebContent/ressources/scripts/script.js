window.addEventListener("load", function(){
    let champs = document.querySelectorAll(".mdl-textfield__input");
    champs.forEach(e => {
        e.addEventListener("blur", function(){
            e.required = true;
            console.log("Lost focus");
        });
    });

    let submit = document.querySelector(".valider");
    submit.onsubmit = champs.forEach(e => {
        e.required = true;
        return true;
    });
});