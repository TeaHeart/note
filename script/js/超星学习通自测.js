document.querySelectorAll(".questionLi").forEach(e => {
    let all = e.innerText;
    let ans = e.querySelector(".mark_answer").innerText;
    let split = all.length - ans.length;
    alert(all.substring(0, split));
    alert(all.substring(split));
});
