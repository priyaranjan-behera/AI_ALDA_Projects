fid = fopen('locations.csv');
c = textscan(fid,'%s %f %f %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s','HeaderLines', 1, 'Delimiter',',' );
fclose(fid);
data(:,1) = c{2};
data(:,2) = c{3};

figure('Name','All Data','NumberTitle','off')
scatter(data(:,2), data(:,1), 15)
ylabel('Longitude');
xlabel('Latitude');
title('Scatter of all the Data Points')

lat = data(:,2)
long = data(:,1)
corr(lat, long)

DistancePlot('euclidean', 0);
DistancePlot('cityblock', 0);
DistancePlot('minkowski', 3);
DistancePlot('chebychev', 0);
DistancePlot('cosine', 0);
DistancePlot('mahalanobis', 0);
