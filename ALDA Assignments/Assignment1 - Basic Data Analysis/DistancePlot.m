function [] = DistancePlot(x,y)

fid = fopen('locations.csv');
c = textscan(fid,'%s %f %f %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s','HeaderLines', 1, 'Delimiter',',' );
fclose(fid);
data(:,1) = c{2};
data(:,2) = c{3};

lat = data(:,2);
long = data(:,1);

P(1,1) = mean(lat);
P(1,2)=mean(long);

for i=1:size(lat)
    X = zeros(2,2);
    X(1,1) = P(1,1);
    X(1,2) = P(1,2);
    X(2,1) = lat(i);
    X(2,2) = long(i);
    if strcmp(x,'minkowski') == 1
        distance(i) = pdist(X, x, y);
    elseif strcmp(x,'mahalanobis') == 1
        covmat = cov(X);
        diff = X(1,:) - X(2,:);
        distance(i) = diff*covmat*diff';
    else
        distance(i) = pdist(X, x);
    end
    distanceMat(i, 1) = lat(i);
    distanceMat(i, 2) = long(i);
    distanceMat(i, 3) = distance(i);
end

distanceMat = sortrows(distanceMat, 3);

figure('Name',strcat(x, ':1'),'NumberTitle','off')
scatter(data(:,2), data(:,1), '.b')
hold
for i = 1:10
    plot(distanceMat(i,1), distanceMat(i,2), 'or' )
end
ylabel('Longitude');
xlabel('Latitude');
title(strcat(x, ' distance plot wrt all data points'))
plot(P(1), P(2), 'xr')

figure('Name',strcat(x, ':2'),'NumberTitle','off')
scatter(distanceMat(1:10,1), distanceMat(1:10,2), 15)
hold
ylabel('Longitude');
xlabel('Latitude');
title(strcat(x, ' distance plot with only closest 10 points'))
plot(P(1), P(2), 'xr')

fprintf(strcat(x, ' - 10 closest points'))
distanceMat(1:10,1:2)




