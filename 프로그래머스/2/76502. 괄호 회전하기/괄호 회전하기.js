function solution(s) {
  const open = new Set(["(", "{", "["]);
  const pair = { ")": "(", "}": "{", "]": "[" };
  let count = 0;

  const arr = s.split("");
  for (let i = 0; i < s.length; i++) {
    arr.unshift(arr.pop());

    const stack = [];
    let valid   = true;
    for (const i of arr) {
      if (open.has(i)) stack.push(i);
      else if (stack.pop() !== pair[i]) { 
          valid = false; 
          break; 
      }
    }

    if (valid && stack.length === 0) count++;
  }
  return count;
}
