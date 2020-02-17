import nav from "./nav";
import makeButton from "./button";
import {makeColorStyle} from "./button-styles";
import imageUrl from "./icon-square-big.jpg";
import makeImage from "./image";
import footerStyles from "./footer.css";
import buttonStyles from "./button.css";
const loadFooter = () => import("./footer");

const image = makeImage(imageUrl);
const button = makeButton("Yay! A Button!");

button.addEventListener("click", e => {
    loadFooter().then(m => {
        document.body.appendChild(m.footer);
    });
});

button.style = makeColorStyle("cyan");
document.body.appendChild(button);
document.body.appendChild(image);
