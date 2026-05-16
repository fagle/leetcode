/* 178. Rank Scores */
/* Runtime: 635 ms */
/* beats 90.30% submissions */
CREATE TABLE Scores (Id INT, Score DOUBLE);
INSERT INTO Scores VALUES (1, 3.50);
INSERT INTO Scores VALUES (2, 3.65);
INSERT INTO Scores VALUES (3, 4.00);
INSERT INTO Scores VALUES (4, 3.85);
INSERT INTO Scores VALUES (5, 4.00);
INSERT INTO Scores VALUES (6, 3.65);

SELECT
  t.Score AS Score,
  Rank
FROM
  (
    SELECT
      (@Rank := @Rank + 1) AS Rank,
      S.Score
    FROM
      (SELECT @Rank := 0) AS R,
      (
        SELECT DISTINCT Score
        FROM Scores
        ORDER BY Score DESC
      ) AS S
  ) AS t
  JOIN Scores a
WHERE t.Score = a.Score
ORDER BY Rank;
