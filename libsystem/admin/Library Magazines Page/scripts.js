// scripts.js
document.addEventListener('DOMContentLoaded', () => {
    // JavaScript for dynamic functionalities if needed
});

const texts = ["Tomatillo water chestnut mustard cabbage yarrow sierra leone bologi. Watercress green bean groundnut earthnut pea dandelion radicchio"];
let count = 0;
let index = 0;
let currentText = '';
let letter = '';

function type() {
  if (count === texts.length) {
    count = 0;
  }
  currentText = texts[count];
  letter = currentText.slice(0, ++index);

  document.getElementById('typing').textContent = letter;
  if (letter.length === currentText.length) {
    count++;
    index = 0;
    setTimeout(type, 1500); // Pause before typing the next text
  } else {
    setTimeout(type, 70); // Typing speed
  }
}

document.addEventListener("DOMContentLoaded", type);