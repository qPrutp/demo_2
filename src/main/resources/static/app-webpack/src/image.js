const makeImage = (url, height = 100, width = 100) => {
    const image = document.createElement("img");

    image.width = width;
    image.height = height;
    image.src = url;
    return image;
};

export default makeImage;
