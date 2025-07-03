function solution(maps) {
  const dx = [0, 0, 1, -1];
  const dy = [1, -1, 0, 0];
  const N = maps.length, M = maps[0].length;

  const q = [{ x: 0, y: 0, dist: 1 }];
  let head = 0;

  const visited = new Set(['0,0']);

  while (head < q.length) {
    const { x, y, dist } = q[head++];

    if (x === M - 1 && y === N - 1) return dist;

    for (let k = 0; k < 4; k++) {
      const nx = x + dx[k], ny = y + dy[k];
      if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
      if (maps[ny][nx] === 0) continue;
      const key = `${nx}, ${ny}`;
      if (visited.has(key)) continue;

      visited.add(key);
      q.push({ x: nx, y: ny, dist: dist + 1 });
    }
  }
  return -1;
}
